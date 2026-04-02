package net.shirojr.nemuelch.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.shirojr.nemuelch.block.custom.*;
import net.shirojr.nemuelch.block.util.VariationHolder;
import net.shirojr.nemuelch.init.NBVBlocks;
import net.shirojr.nemuelch.init.NBVTags;

import java.util.concurrent.CompletableFuture;

public class NBVTagGenerators {
    public static void registerAll(FabricDataGenerator.Pack generator) {
        generator.addProvider(ItemTagGenerator::new);
        generator.addProvider(BlockTagGenerator::new);
    }

    public static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
        public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            FabricTagProvider<Item>.FabricTagBuilder centeredHalfSlabsTag = getOrCreateTagBuilder(NBVTags.Items.CENTERED_HALF_SLABS);
            FabricTagProvider<Item>.FabricTagBuilder centeredVerticalHalfSlabsTag = getOrCreateTagBuilder(NBVTags.Items.CENTERED_VERTICAL_HALF_SLABS);
            FabricTagProvider<Item>.FabricTagBuilder chimneysTag = getOrCreateTagBuilder(NBVTags.Items.CHIMNEYS);
            FabricTagProvider<Item>.FabricTagBuilder doublePlatesTag = getOrCreateTagBuilder(NBVTags.Items.DOUBLE_PLATES);
            FabricTagProvider<Item>.FabricTagBuilder halfSlabsTag = getOrCreateTagBuilder(NBVTags.Items.HALF_SLABS);
            FabricTagProvider<Item>.FabricTagBuilder platesTag = getOrCreateTagBuilder(NBVTags.Items.PLATES);
            FabricTagProvider<Item>.FabricTagBuilder smallFencesTag = getOrCreateTagBuilder(NBVTags.Items.SMALL_FENCES);
            FabricTagProvider<Item>.FabricTagBuilder verticalHalfSlabsTag = getOrCreateTagBuilder(NBVTags.Items.VERTICAL_HALF_SLABS);

            for (CenteredHalfSlabBlock entry : NBVBlocks.CENTERED_HALF_SLABS) {
                centeredHalfSlabsTag.add(entry.asItem());
            }
            for (CenteredVerticalHalfSlabBlock entry : NBVBlocks.CENTERED_VERTICAL_HALF_SLABS) {
                centeredVerticalHalfSlabsTag.add(entry.asItem());
            }
            for (ChimneyBlock entry : NBVBlocks.CHIMNEYS) {
                chimneysTag.add(entry.asItem());
            }
            for (DoublePlatesBlock entry : NBVBlocks.DOUBLE_PLATES) {
                doublePlatesTag.add(entry.asItem());
            }
            for (HalfSlabBlock entry : NBVBlocks.HALF_SLABS) {
                halfSlabsTag.add(entry.asItem());
            }
            for (PlateBlock entry : NBVBlocks.PLATES) {
                platesTag.add(entry.asItem());
            }
            for (SmallFenceBlock entry : NBVBlocks.SMALL_FENCES) {
                smallFencesTag.add(entry.asItem());
            }
            for (VerticalHalfSlabBlock entry : NBVBlocks.VERTICAL_HALF_SLABS) {
                verticalHalfSlabsTag.add(entry.asItem());
            }
        }
    }

    public static class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
        public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
            FabricTagProvider<Block>.FabricTagBuilder climbableTag = getOrCreateTagBuilder(BlockTags.CLIMBABLE);

            FabricTagProvider<Block>.FabricTagBuilder centeredHalfSlabsTag = getOrCreateTagBuilder(NBVTags.Blocks.CENTERED_HALF_SLABS);
            FabricTagProvider<Block>.FabricTagBuilder centeredVerticalHalfSlabsTag = getOrCreateTagBuilder(NBVTags.Blocks.CENTERED_VERTICAL_HALF_SLABS);
            FabricTagProvider<Block>.FabricTagBuilder chimneysTag = getOrCreateTagBuilder(NBVTags.Blocks.CHIMNEYS);
            FabricTagProvider<Block>.FabricTagBuilder doublePlatesTag = getOrCreateTagBuilder(NBVTags.Blocks.DOUBLE_PLATES);
            FabricTagProvider<Block>.FabricTagBuilder halfSlabsTag = getOrCreateTagBuilder(NBVTags.Blocks.HALF_SLABS);
            FabricTagProvider<Block>.FabricTagBuilder platesTag = getOrCreateTagBuilder(NBVTags.Blocks.PLATES);
            FabricTagProvider<Block>.FabricTagBuilder smallFencesTag = getOrCreateTagBuilder(NBVTags.Blocks.SMALL_FENCES);
            FabricTagProvider<Block>.FabricTagBuilder verticalHalfSlabsTag = getOrCreateTagBuilder(NBVTags.Blocks.VERTICAL_HALF_SLABS);

            for (CenteredHalfSlabBlock entry : NBVBlocks.CENTERED_HALF_SLABS) {
                centeredHalfSlabsTag.add(entry);
            }
            for (CenteredVerticalHalfSlabBlock entry : NBVBlocks.CENTERED_VERTICAL_HALF_SLABS) {
                centeredVerticalHalfSlabsTag.add(entry);
            }
            for (ChimneyBlock entry : NBVBlocks.CHIMNEYS) {
                climbableTag.add(entry);
                chimneysTag.add(entry);
            }
            for (DoublePlatesBlock entry : NBVBlocks.DOUBLE_PLATES) {
                climbableTag.add(entry.getBlock());
                doublePlatesTag.add(entry.getBlock());
            }
            for (HalfSlabBlock entry : NBVBlocks.HALF_SLABS) {
                halfSlabsTag.add(entry);
            }
            for (PlateBlock entry : NBVBlocks.PLATES) {
                platesTag.add(entry);
            }
            for (SmallFenceBlock entry : NBVBlocks.SMALL_FENCES) {
                smallFencesTag.add(entry);
            }
            for (VerticalHalfSlabBlock entry : NBVBlocks.VERTICAL_HALF_SLABS) {
                verticalHalfSlabsTag.add(entry);
            }
            for (VariationHolder variationHolder : NBVBlocks.VARIATION_HOLDERS) {
                for (TagKey<Block> blockTag : variationHolder.getVariant().blockTags()) {
                    getOrCreateTagBuilder(blockTag).add(variationHolder.getBlock());
                }
            }
        }
    }
}
