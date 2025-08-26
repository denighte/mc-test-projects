package com.unknown.patch.mixin;

import dev.shadowsoffire.attributeslib.api.ALCombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.projectile.ProjectilePatch;
import yesman.epicfight.world.damagesource.EpicFightDamageSource;

@Mixin(value = ALCombatRules.class, remap = false)
public class ALCombatRulesMixin {

    @ModifyVariable(method = "getDamageAfterArmor(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/damagesource/DamageSource;FFF)F", at = @At(value = "HEAD"), ordinal = 1,
            slice = @Slice(to = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F")), allow = 1)
    private static float adjustProjectileArmorImpact(float armorModified, LivingEntity entity, DamageSource source, float amount, float armor, float toughness) {
        if (source.isIndirect() && source.getDirectEntity() != null) {
            ProjectilePatch<?> projectileCap = EpicFightCapabilities.getEntityPatch(source.getDirectEntity(), ProjectilePatch.class);
            if (projectileCap != null) {
                EpicFightDamageSource epicFightDamageSource = projectileCap.getEpicFightDamageSource(source);
                float shred = epicFightDamageSource.getArmorNegation() * 0.01F * (1 - Math.min(toughness * 0.02F, 0.6F));
                armorModified *= 1 - shred;
            }
        }
        return armorModified;
    }

    @ModifyVariable(method = "getDamageAfterArmor(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/damagesource/DamageSource;FFF)F", at = @At(value = "STORE"), ordinal = 3,
            slice = @Slice(to = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F")), allow = 1)
    private static float adjustApothicShred(float shred, LivingEntity entity, DamageSource source, float amount, float armor, float toughness) {
        EpicFightDamageSource epicFightDamageSource = null;
        LivingEntityPatch<?> attackerEntityPatch = EpicFightCapabilities.getEntityPatch(source.getEntity(), LivingEntityPatch.class);

        if (source instanceof EpicFightDamageSource instance) {
            epicFightDamageSource = instance;
        } else if (attackerEntityPatch != null) {
            epicFightDamageSource = attackerEntityPatch.getEpicFightDamageSource();
        }

        if (epicFightDamageSource != null) {
            shred = Math.min(shred + epicFightDamageSource.getArmorNegation() * 0.01F , 2.0F);
        }
        return shred;
    }
}
