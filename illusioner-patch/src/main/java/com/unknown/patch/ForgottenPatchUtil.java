package com.unknown.patch;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import org.violetmoon.quark.content.mobs.client.layer.forgotten.ForgottenClothingLayer;
import org.violetmoon.quark.content.mobs.client.layer.forgotten.ForgottenEyesLayer;
import org.violetmoon.quark.content.mobs.entity.Forgotten;
import org.violetmoon.quark.content.mobs.module.ForgottenModule;
import yesman.epicfight.api.animation.JointTransform;
import yesman.epicfight.api.animation.Pose;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.client.mesh.HumanoidMesh;
import yesman.epicfight.client.renderer.patched.entity.PHumanoidRenderer;
import yesman.epicfight.client.renderer.patched.layer.EmptyLayer;
import yesman.epicfight.client.renderer.patched.layer.PatchedEyesLayer;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.capabilities.entitypatch.mob.SkeletonPatch;
import yesman.epicfight.world.item.EpicFightItems;

public class ForgottenPatchUtil {


    public static void addForgottenRenderer(PatchedRenderersEvent.Add event) {
        event.addPatchedEntityRenderer(ForgottenModule.forgottenType,
                (type) -> new PForgottenRenderer(event.getContext(), type).initLayerLast(event.getContext(), type));
    }

    public static void addForgottenPatch(EntityPatchRegistryEvent event) {
        event.getTypeEntry().put(ForgottenModule.forgottenType, (entityIn) -> ForgottenPatch::new);
    }

    public static void addForgottenArmature(ModelBuildEvent.ArmatureBuild event) {
        Armatures.registerEntityTypeArmature(ForgottenModule.forgottenType, Armatures.SKELETON);
    }

    public static void onSpawnEventSoftFix(MobSpawnEvent.FinalizeSpawn event) {
        if (event.getEntity() instanceof Forgotten && !event.getEntity().getTags().contains("wom-bow-replaced")) {
            event.getEntity().addTag("wom-bow-replaced");
        }
    }

    public static void onSpawnEventHardFix(MobSpawnEvent.AllowDespawn event) {
        if (!event.getEntity().getTags().contains("forgotten-weapon-fixed")) {
            if (event.getEntity() instanceof Forgotten forgotten
                    && !Items.BOW.equals(forgotten.getMainHandItem().getItem())
                    && !Items.BOW.equals(forgotten.getEntityData().get(Forgotten.SHEATHED_ITEM).getItem())) {
                forgotten.addTag("forgotten-weapon-fixed");
                ItemStack bow = new ItemStack(Items.BOW);
                EnchantmentHelper.enchantItem(forgotten.getRandom(), bow, 20, false);
                forgotten.getEntityData().set(Forgotten.SHEATHED_ITEM, bow);
            }
        }
    }

    public static void onLoad() {
        if ("soft".equals(ModPatchMod.PATCH_METHOD.get())) {
            MinecraftForge.EVENT_BUS.addListener(ForgottenPatchUtil::onSpawnEventSoftFix);
        } else if ("hard".equals(ModPatchMod.PATCH_METHOD.get())) {
            MinecraftForge.EVENT_BUS.addListener(EventPriority.LOW, ForgottenPatchUtil::onSpawnEventHardFix);
        }
    }

    public static class PForgottenRenderer extends PHumanoidRenderer<PathfinderMob, SkeletonPatch<PathfinderMob>, HumanoidModel<PathfinderMob>, HumanoidMobRenderer<PathfinderMob, HumanoidModel<PathfinderMob>>, HumanoidMesh> {

        private static final ResourceLocation TEXTURE = new ResourceLocation("quark", "textures/model/entity/forgotten/eye.png");

        public PForgottenRenderer(EntityRendererProvider.Context context, EntityType<?> entityType) {
            super(() -> Meshes.SKELETON, context, entityType);
            this.addPatchedLayer(ForgottenClothingLayer.class, new EmptyLayer<>());
            this.addPatchedLayer(ForgottenEyesLayer.class, new PatchedEyesLayer<>(TEXTURE, () -> Meshes.SKELETON));
        }

        @Override
        protected void setJointTransforms(SkeletonPatch<PathfinderMob> entitypatch, Armature armature, Pose pose, float partialTicks) {
            super.setJointTransforms(entitypatch, armature, pose, partialTicks);
            pose.getOrDefaultTransform("Root").frontResult(JointTransform.getScale(new Vec3f(1.2F, 1.2F, 1.2F)), OpenMatrix4f::mul);
        }
    }

    public static class ForgottenPatch extends SkeletonPatch<Forgotten> {
        public ForgottenPatch() {
        }

        public void onJoinWorld(Forgotten entityIn, EntityJoinLevelEvent event) {
            super.onJoinWorld(entityIn, event);
            (this.original).setItemSlot(EquipmentSlot.CHEST, new ItemStack(EpicFightItems.STRAY_ROBE.get()));
            (this.original).setItemSlot(EquipmentSlot.LEGS, new ItemStack(EpicFightItems.STRAY_PANTS.get()));
        }
    }
}
