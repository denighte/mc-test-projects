package com.unknown.patch.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Illusioner.class)
public abstract class IllusionerMixin extends SpellcasterIllager {
    protected IllusionerMixin(EntityType<? extends SpellcasterIllager> p_33724_, Level p_33725_) {
        super(p_33724_, p_33725_);
    }

    @Inject(method = "getIllusionOffsets", at = @At("RETURN"), cancellable = true)
    public void modifyYOffset(CallbackInfoReturnable<Vec3[]> cr) {
        Vec3[] toModify = cr.getReturnValue();
        Vec3[] result = new Vec3[toModify.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = new Vec3(toModify[i].x, 0.0D, toModify[i].z);
        }
        cr.setReturnValue(result);
    }

}
