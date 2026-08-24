package net.shirojr.nbv.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.shirojr.nbv.block.util.VariationHolder;
import net.shirojr.nbv.init.NBVBlockVariations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {
    private LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @ModifyExpressionValue(method = "applyClimbingSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean expandToAllScaffoldingVariations(boolean original) {
        return original || getBlockStateAtPos().getBlock() instanceof VariationHolder holder && holder.getVariant().equals(NBVBlockVariations.SCAFFOLDING);
    }
}
