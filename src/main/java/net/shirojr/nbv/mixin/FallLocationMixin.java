package net.shirojr.nbv.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.FallLocation;
import net.shirojr.nbv.block.util.VariationHolder;
import net.shirojr.nbv.init.NBVBlockVariations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FallLocation.class)
public abstract class FallLocationMixin {
    @Definition(id = "isOf", method = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z")
    @Definition(id = "SCAFFOLDING", field = "Lnet/minecraft/block/Blocks;SCAFFOLDING:Lnet/minecraft/block/Block;")
    @Expression("?.isOf(SCAFFOLDING)")
    @ModifyExpressionValue(method = "fromBlockState", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    private static boolean expandToAllScaffoldingVariations(boolean original, @Local(argsOnly = true) BlockState state) {
        return original || state.getBlock() instanceof VariationHolder holder && holder.getVariant().equals(NBVBlockVariations.SCAFFOLDING);
    }
}
