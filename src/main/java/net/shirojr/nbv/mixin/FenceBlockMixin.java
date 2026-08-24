package net.shirojr.nbv.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.shirojr.nbv.init.NBVTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FenceBlock.class)
public abstract class FenceBlockMixin {
    @Inject(method = "canConnectToFence", at = @At("RETURN"), cancellable = true)
    private void addFenceConnectingBlockTag(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        boolean original = cir.getReturnValue();
        cir.setReturnValue(original || state.isIn(NBVTags.Blocks.CONNECTABLES));
    }
}
