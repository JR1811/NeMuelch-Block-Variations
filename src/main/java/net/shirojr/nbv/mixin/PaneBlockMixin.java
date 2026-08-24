package net.shirojr.nbv.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.shirojr.nbv.init.NBVTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PaneBlock.class)
public abstract class PaneBlockMixin {
    @ModifyExpressionValue(method = "connectsTo", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean expandTConnectableBlocks(boolean original, @Local(argsOnly = true) BlockState state) {
        return original || state.isIn(NBVTags.Blocks.CONNECTABLES);
    }
}
