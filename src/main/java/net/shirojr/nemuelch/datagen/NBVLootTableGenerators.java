package net.shirojr.nemuelch.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.shirojr.nemuelch.block.util.VariationHolder;
import net.shirojr.nemuelch.init.NBVBlocks;

public class NBVLootTableGenerators {
    public static void registerAll(FabricDataGenerator.Pack pack) {
        pack.addProvider(BlockLootGenerator::new);
    }

    public static class BlockLootGenerator extends FabricBlockLootTableProvider {
        public BlockLootGenerator(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate() {
            for (VariationHolder variationBlock : NBVBlocks.VARIATION_HOLDERS) {
                addDrop(variationBlock.getBlock());
            }
        }
    }
}
