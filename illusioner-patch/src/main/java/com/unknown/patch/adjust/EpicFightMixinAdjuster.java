package com.unknown.patch.adjust;

import com.bawnorton.mixinsquared.adjuster.tools.AdjustableAnnotationNode;
import com.bawnorton.mixinsquared.adjuster.tools.AdjustableInjectNode;
import com.bawnorton.mixinsquared.api.MixinAnnotationAdjuster;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.List;

public class EpicFightMixinAdjuster implements MixinAnnotationAdjuster {
    @Override
    public AdjustableAnnotationNode adjust(List<String> targetClassNames, String mixinClassName, MethodNode method, AdjustableAnnotationNode annotation) {
        if(!mixinClassName.equals("yesman.epicfight.mixin.MixinLivingEntity")) {
            return annotation;
        }
        if(!annotation.is(Inject.class)) return annotation;

        AdjustableInjectNode injectOpNode = annotation.as(AdjustableInjectNode.class);

        if(injectOpNode.getMethod()
                .get(0)
                .equals("getDamageAfterArmorAbsorb(Lnet/minecraft/world/damagesource/DamageSource;F)F")) {
            return null;
        }
        return annotation;
    }
}
