package net.shirojr.nemuelch.init;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.shirojr.nemuelch.block.util.Variation;
import org.jetbrains.annotations.Nullable;

public class NBVBlockBiomeTinter implements BlockColorProvider, ItemColorProvider {
    private final Variation variant;

    public NBVBlockBiomeTinter(Variation variant) {
        this.variant = variant;
    }

    @Override
    public int getColor(BlockState state, @Nullable BlockRenderView world, @Nullable BlockPos pos, int tintIndex) {
        if (world == null || pos == null || variant.tint() == null) return -1;
        BlockColorProvider blockColorProvider = ColorProviderRegistry.BLOCK.get(variant.parentBlock());
        if (blockColorProvider == null) return -1;
        return blockColorProvider.getColor(state, world, pos, tintIndex);
    }

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        Block block = variant.parentBlock();
        BlockColorProvider blockColorProvider = ColorProviderRegistry.BLOCK.get(block);
        if (blockColorProvider == null) return -1;
        return blockColorProvider.getColor(block.getDefaultState(), null, null, tintIndex);
    }
}
