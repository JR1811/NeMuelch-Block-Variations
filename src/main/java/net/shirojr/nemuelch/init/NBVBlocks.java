package net.shirojr.nemuelch.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.shirojr.nemuelch.NBVMain;
import net.shirojr.nemuelch.block.custom.*;
import net.shirojr.nemuelch.block.util.Variation;
import net.shirojr.nemuelch.block.util.VariationHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;

@SuppressWarnings("unused")
public interface NBVBlocks {
    List<Block> ALL_BLOCKS = new ArrayList<>();
    List<VariationHolder> VARIATION_HOLDERS = new ArrayList<>();

    List<ChimneyBlock> CHIMNEYS = registerVariationBlocks(
            "chimney",
            (variant) -> FabricBlockSettings.copy(variant.parentBlock()),
            ChimneyBlock::new
    );

    List<PlateBlock> PLATES = registerVariationBlocks(
            "plate",
            (variant) -> FabricBlockSettings.copy(variant.parentBlock()),
            PlateBlock::new
    );

    List<DoublePlatesBlock> DOUBLE_PLATES = registerVariationBlocks(
            "double_plates",
            variation -> FabricBlockSettings.copy(variation.parentBlock()),
            DoublePlatesBlock::new
    );

    List<HalfSlabBlock> HALF_SLABS = registerVariationBlocks(
            "half_slab",
            variation -> FabricBlockSettings.copy(variation.parentBlock()),
            HalfSlabBlock::new
    );

    List<VerticalHalfSlabBlock> VERTICAL_HALF_SLABS = registerVariationBlocks(
            "vertical_half_slab",
            variation -> FabricBlockSettings.copy(variation.parentBlock()),
            VerticalHalfSlabBlock::new
    );

    List<CenteredVerticalHalfSlabBlock> CENTERED_VERTICAL_HALF_SLABS = registerVariationBlocks(
            "centered_vertical_half_slab",
            variation -> FabricBlockSettings.copy(variation.parentBlock()),
            CenteredVerticalHalfSlabBlock::new
    );

    List<CenteredHalfSlabBlock> CENTERED_HALF_SLABS = registerVariationBlocks(
            "centered_half_slab",
            variation -> FabricBlockSettings.copy(variation.parentBlock()),
            CenteredHalfSlabBlock::new
    );

    List<SmallFenceBlock> SMALL_FENCES = registerVariationBlocks(
            "small_fence",
            variation -> FabricBlockSettings.copy(variation.parentBlock()),
            SmallFenceBlock::new
    );

    @SuppressWarnings("SameParameterValue")
    static <T extends Block> T register(String name, T entry, boolean registerDefaultItem, List<List<Item>> itemLists) {
        T registeredEntry = Registry.register(Registries.BLOCK, NBVMain.getId(name), entry);
        if (registerDefaultItem) {
            BlockItem registeredItemEntry = Registry.register(Registries.ITEM, NBVMain.getId(name), new BlockItem(registeredEntry, new Item.Settings()));
            for (List<Item> list : itemLists) {
                list.add(registeredItemEntry);
            }
        }
        ALL_BLOCKS.add(registeredEntry);
        return registeredEntry;
    }

    @SuppressWarnings("SameParameterValue")
    private static <T extends Block & VariationHolder> List<T> registerVariationBlocks(
            String nameSuffix, Function<Variation, AbstractBlock.Settings> settings, BiFunction<AbstractBlock.Settings, Variation, T> blockFactory) {
        List<T> result = new ArrayList<>();
        for (Variation variant : NBVBlockVariations.ALL_VARIATIONS) {
            AbstractBlock.Settings blockSettings = settings.apply(variant);

            //FIXME: this is a hacky fix ngl...
            //  Settings which use Properties, which the variation block doesn't have need to get changed
            //  Example would be Log Blocks which use AXIS Properties for map colors
            if (variant.parentBlock().getDefaultState().contains(Properties.AXIS)) {
                blockSettings = blockSettings.mapColor(MapColor.BLACK);
            }
            if (variant.parentBlock() instanceof RedstoneOreBlock) {
                blockSettings = blockSettings.luminance(value -> 0);
            }

            T registeredBlock = register(
                    variant.name().toLowerCase(Locale.ROOT) + "_" + nameSuffix,
                    blockFactory.apply(blockSettings, variant),
                    true,
                    List.of(NBVItems.VARIATION_BLOCK_ITEMS)
            );
            result.add(registeredBlock);
            VARIATION_HOLDERS.add(registeredBlock);
            ALL_BLOCKS.add(registeredBlock);
        }
        return result;
    }

    static void initialize() {
        // static initialisation
    }
}
