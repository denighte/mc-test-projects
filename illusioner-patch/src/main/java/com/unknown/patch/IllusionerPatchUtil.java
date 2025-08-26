package com.unknown.patch;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Illusioner;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;
import yesman.epicfight.client.renderer.patched.entity.PIllagerRenderer;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.mob.AbstractIllagerPatch;

public class IllusionerPatchUtil {
    public static void addIllusionerRenderer(PatchedRenderersEvent.Add event) {
        event.addPatchedEntityRenderer(EntityType.ILLUSIONER,
                (type) -> new PIllagerRenderer<>(event.getContext(), type).initLayerLast(event.getContext(), type));
    }

    public static void addIllusionerPatch(EntityPatchRegistryEvent event) {
        event.getTypeEntry().put(EntityType.ILLUSIONER, (entityIn) -> {
            return IllusionerPatch::new;
        });
    }

    public static void addIllusionerArmature(ModelBuildEvent.ArmatureBuild event) {
        Armatures.registerEntityTypeArmature(EntityType.ILLUSIONER, Armatures.BIPED);
    }

    public static class IllusionerPatch extends AbstractIllagerPatch<Illusioner> {
        public IllusionerPatch() {
            super(Faction.ILLAGER);
        }

        @Override
        public void initAnimator(Animator animator) {
            animator.addLivingAnimation(LivingMotions.IDLE, Animations.BIPED_IDLE);
            animator.addLivingAnimation(LivingMotions.WALK, Animations.BIPED_WALK);
            animator.addLivingAnimation(LivingMotions.CHASE, Animations.BIPED_WALK);
            animator.addLivingAnimation(LivingMotions.FALL, Animations.BIPED_FALL);
            animator.addLivingAnimation(LivingMotions.MOUNT, Animations.BIPED_MOUNT);
            animator.addLivingAnimation(LivingMotions.DEATH, Animations.BIPED_DEATH);
            animator.addLivingAnimation(LivingMotions.SPELLCAST, Animations.EVOKER_CAST_SPELL);
        }

        @Override
        public void updateMotion(boolean considerInaction) {
            this.commonAggressiveRangedMobUpdateMotion(considerInaction);
            if (this.getOriginal().isCastingSpell()) {
                currentLivingMotion = LivingMotions.SPELLCAST;
            }
        }

        @Override
        public void setAIAsInfantry(boolean holdingRangedWeapon) {
            if (!holdingRangedWeapon) {
                super.setAIAsInfantry(false);
            }
        }
    }
}
