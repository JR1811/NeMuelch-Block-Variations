package net.shirojr.nbv.mixin.client;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.shirojr.nbv.init.NBVTags;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Debug(export = true)
@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "getBlockParticle", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private void handleBlockMarkerInVariations(CallbackInfoReturnable<Block> cir) {
        ClientPlayerEntity player = client.player;
        if (player == null) return;
        ItemStack itemStack = player.getMainHandStack();
        if (cir.getReturnValue() == null) {
            if (itemStack.isIn(NBVTags.Items.BARRIER_RENDERING) && itemStack.getItem() instanceof BlockItem blockItem) {
                cir.setReturnValue(blockItem.getBlock());
            }
        }
    }

    @Definition(id = "block", local = @Local(type = Block.class))
    @Definition(id = "blockStateBlock", method = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;")
    @Expression("block == ?.blockStateBlock()")
    @ModifyExpressionValue(method = "randomBlockDisplayTick", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    private boolean displayBarrierParticleForAllBarrierBlocks(boolean original, @Local(argsOnly = true) Block block, @Local BlockState state) {
        return original || (block != null && state.isIn(NBVTags.Blocks.BARRIER_RENDERING));
    }
}
