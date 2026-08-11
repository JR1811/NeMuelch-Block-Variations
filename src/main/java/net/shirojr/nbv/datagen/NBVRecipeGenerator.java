package net.shirojr.nbv.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.shirojr.nbv.block.custom.*;
import net.shirojr.nbv.init.NBVBlocks;

import java.util.function.Consumer;

public class NBVRecipeGenerator extends FabricRecipeProvider {
    public NBVRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        generateChimneys(consumer);
        generatePlates(consumer);
        generateHalfSlabs(consumer);
        generateCenteredHalfSlabs(consumer);
        generateSmallFences(consumer);
        generateVerticalStairs(consumer);
        generateRods(consumer);
        generateQuarterSlabs(consumer);
    }

    private static void generateChimneys(Consumer<RecipeJsonProvider> consumer) {
        for (ChimneyBlock chimneyBlock : NBVBlocks.CHIMNEYS.values()) {
            Block parentBlock = chimneyBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, chimneyBlock, 6)
                    .pattern("# #")
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }

    private static void generatePlates(Consumer<RecipeJsonProvider> consumer) {
        for (PlateBlock plateBlock : NBVBlocks.PLATES.values()) {
            Block parentBlock = plateBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, plateBlock, 3)
                    .pattern("#")
                    .pattern("#")
                    .pattern("#")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, parentBlock, 3)
                    .pattern("#")
                    .pattern("#")
                    .pattern("#")
                    .input('#', plateBlock)
                    .criterion(hasItem(plateBlock), conditionsFromItem(plateBlock))
                    .offerTo(consumer, getItemId(parentBlock) + "_from_" + getItemId(plateBlock).getPath());
        }
        for (DoublePlatesBlock doublePlatesBlock : NBVBlocks.DOUBLE_PLATES.values()) {
            Block parentBlock = doublePlatesBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, doublePlatesBlock, 4)
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }

    private static void generateHalfSlabs(Consumer<RecipeJsonProvider> consumer) {
        for (HalfSlabBlock halfSlabBlock : NBVBlocks.HALF_SLABS.values()) {
            Block parentBlock = halfSlabBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, halfSlabBlock, 3)
                    .pattern("# ")
                    .pattern("##")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }

        for (VerticalHalfSlabBlock verticalHalfSlab : NBVBlocks.VERTICAL_HALF_SLABS.values()) {
            Block parentBlock = verticalHalfSlab.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, verticalHalfSlab, 3)
                    .pattern("##")
                    .pattern("# ")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }

    private static void generateCenteredHalfSlabs(Consumer<RecipeJsonProvider> consumer) {
        for (CenteredVerticalHalfSlabBlock centeredVerticalHalfSlabBlock : NBVBlocks.CENTERED_VERTICAL_HALF_SLABS.values()) {
            Block parentBlock = centeredVerticalHalfSlabBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, centeredVerticalHalfSlabBlock, 4)
                    .pattern("###")
                    .pattern(" # ")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
        for (CenteredHalfSlabBlock centeredHalfSlab : NBVBlocks.CENTERED_HALF_SLABS.values()) {
            Block parentBlock = centeredHalfSlab.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, centeredHalfSlab, 4)
                    .pattern(" # ")
                    .pattern("###")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }

    private static void generateSmallFences(Consumer<RecipeJsonProvider> consumer) {
        for (SmallFenceBlock smallFenceBlock : NBVBlocks.SMALL_FENCES.values()) {
            Block parentBlock = smallFenceBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, smallFenceBlock, 4)
                    .pattern("#s#")
                    .input('#', parentBlock)
                    .input('s', Items.STICK)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }

    private static void generateVerticalStairs(Consumer<RecipeJsonProvider> consumer) {
        for (VerticalStairBlock verticalStairBlock : NBVBlocks.VERTICAL_STAIRS.values()) {
            Block parentBlock = verticalStairBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, verticalStairBlock, 4)
                    .pattern("###")
                    .pattern("## ")
                    .pattern("#  ")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }

    private static void generateRods(Consumer<RecipeJsonProvider> consumer) {
        for (var entry : NBVBlocks.ROD.entrySet()) {
            RodVariationBlock rodBlock = entry.getValue();
            Block parentBlock = rodBlock.getVariant().parentBlock();
            SmallFenceBlock smallFenceBlock = NBVBlocks.SMALL_FENCES.get(entry.getKey());
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, rodBlock, 2)
                    .pattern("#")
                    .pattern("s")
                    .input('#', parentBlock)
                    .input('s', smallFenceBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }

        for (var entry : NBVBlocks.KNOBBED_ROD.entrySet()) {
            RodVariationBlock rodBlock = entry.getValue();
            SmallFenceBlock smallFenceBlock = NBVBlocks.SMALL_FENCES.get(entry.getKey());
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, rodBlock, 2)
                    .pattern("s")
                    .pattern("s")
                    .input('s', smallFenceBlock)
                    .criterion(hasItem(smallFenceBlock), conditionsFromItem(smallFenceBlock))
                    .offerTo(consumer);
        }
    }

    private static void generateQuarterSlabs(Consumer<RecipeJsonProvider> consumer) {
        for (var entry : NBVBlocks.QUARTER_SLAB.entrySet()) {
            HalfSlabBlock halfSlabBlock = NBVBlocks.HALF_SLABS.get(entry.getKey());
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, entry.getValue(), 2)
                    .input(halfSlabBlock)
                    .criterion(hasItem(halfSlabBlock), conditionsFromItem(halfSlabBlock))
                    .offerTo(consumer);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, halfSlabBlock, 1)
                    .input(entry.getValue(), 2)
                    .criterion(hasItem(entry.getValue()), conditionsFromItem(entry.getValue()))
                    .offerTo(consumer, getItemId(entry.getValue()) + "_reverse");
        }
    }

    private static Identifier getItemId(ItemConvertible item) {
        return Registries.ITEM.getId(item.asItem());
    }
}
