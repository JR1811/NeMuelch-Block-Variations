package net.shirojr.nbv;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.shirojr.nbv.block.util.Variation;
import net.shirojr.nbv.block.util.VariationHolder;
import net.shirojr.nbv.init.NBVBlockBiomeTinter;
import net.shirojr.nbv.init.NBVBlockVariations;
import net.shirojr.nbv.init.NBVBlocks;

import java.util.List;

public class NBVClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerBlockRendering();
    }

    private static void registerBlockRendering() {
        for (VariationHolder variationHolder : NBVBlocks.VARIATION_HOLDERS) {
            Variation variant = variationHolder.getVariant();
            List<TagKey<Block>> tags = variant.blockTags();
            if (tags.contains(ConventionalBlockTags.GLASS_BLOCKS) || tags.contains(ConventionalBlockTags.GLASS_PANES)) {
                BlockRenderLayerMap.INSTANCE.putBlock(variationHolder.getBlock(), RenderLayer.getTranslucent());
            }
            if (tags.contains(BlockTags.TRAPDOORS) || tags.contains(BlockTags.DOORS)) {
                BlockRenderLayerMap.INSTANCE.putBlock(variationHolder.getBlock(), RenderLayer.getCutout());
            }
            if (variant.equals(NBVBlockVariations.IRON_BARS)) {
                BlockRenderLayerMap.INSTANCE.putBlock(variationHolder.getBlock(), RenderLayer.getCutout());
            }
            if (tags.contains(BlockTags.LEAVES)) {
                BlockRenderLayerMap.INSTANCE.putBlock(variationHolder.getBlock(), RenderLayer.getCutout());
            }
            if (variant.equals(NBVBlockVariations.SCAFFOLDING)) {
                BlockRenderLayerMap.INSTANCE.putBlock(variationHolder.getBlock(), RenderLayer.getCutout());
            }

            if (variant.tint() != null) {
                NBVBlockBiomeTinter colorProvider = new NBVBlockBiomeTinter(variant);
                ColorProviderRegistry.BLOCK.register(colorProvider, variationHolder.getBlock());
                ColorProviderRegistry.ITEM.register(colorProvider, variationHolder.getBlock());
            }
        }
    }
}
