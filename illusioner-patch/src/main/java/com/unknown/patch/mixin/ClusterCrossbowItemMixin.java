package com.unknown.patch.mixin;

import net.lukas.crossbow_expansion.item.ClusterCrossbowItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ClusterCrossbowItem.class, remap = false)
public class ClusterCrossbowItemMixin {
    @ModifyVariable(method = "shootAll", at = @At("HEAD"), index = 5, argsOnly = true)
    private static float modifyDivergence(float original, Level world, LivingEntity entity, InteractionHand hand, ItemStack stack, float speed, float divergence) {
        return original + 6;
    }
}
