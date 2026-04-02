package net.shirojr.nemuelch.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.shirojr.nemuelch.block.custom.*;
import net.shirojr.nemuelch.init.NBVBlocks;

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
    }

    private static void generateChimneys(Consumer<RecipeJsonProvider> consumer) {
        for (ChimneyBlock chimneyBlock : NBVBlocks.CHIMNEYS) {
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
        for (PlateBlock plateBlock : NBVBlocks.PLATES) {
            Block parentBlock = plateBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, plateBlock, 3)
                    .pattern("#")
                    .pattern("#")
                    .pattern("#")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
        for (DoublePlatesBlock doublePlatesBlock : NBVBlocks.DOUBLE_PLATES) {
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
        for (HalfSlabBlock halfSlabBlock : NBVBlocks.HALF_SLABS) {
            Block parentBlock = halfSlabBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, halfSlabBlock, 3)
                    .pattern("# ")
                    .pattern("##")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }

        for (VerticalHalfSlabBlock verticalHalfSlab : NBVBlocks.VERTICAL_HALF_SLABS) {
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
        for (CenteredVerticalHalfSlabBlock centeredVerticalHalfSlabBlock : NBVBlocks.CENTERED_VERTICAL_HALF_SLABS) {
            Block parentBlock = centeredVerticalHalfSlabBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, centeredVerticalHalfSlabBlock, 4)
                    .pattern("###")
                    .pattern(" # ")
                    .input('#', parentBlock)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
        for (CenteredHalfSlabBlock centeredHalfSlab : NBVBlocks.CENTERED_HALF_SLABS) {
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
        for (SmallFenceBlock smallFenceBlock : NBVBlocks.SMALL_FENCES) {
            Block parentBlock = smallFenceBlock.getVariant().parentBlock();
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, smallFenceBlock, 4)
                    .pattern("#s#")
                    .input('#', parentBlock)
                    .input('s', Items.STICK)
                    .criterion(hasItem(parentBlock), conditionsFromItem(parentBlock))
                    .offerTo(consumer);
        }
    }
}
