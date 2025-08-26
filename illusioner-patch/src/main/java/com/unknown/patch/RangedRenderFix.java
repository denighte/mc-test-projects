package com.unknown.patch;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import yesman.epicfight.client.ClientEngine;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.config.ConfigManager;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ModPatchMod.MOD_ID)
public class RangedRenderFix {
    public static float crossbowOffset;
    public static float bowOffset;
    public static float crouchOffset;
    public static boolean isAnimFiltered;

    static void onLoad()
    {
        crossbowOffset = ModPatchMod.CROSSBOW_OFFSET.get().floatValue();
        bowOffset = ModPatchMod.BOW_OFFSET.get().floatValue();
        crouchOffset = ModPatchMod.CROUCH_OFFSET.get().floatValue();
        isAnimFiltered = ConfigManager.INGAME_CONFIG.filterAnimation.get();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void adjustWeaponPosition(RenderHandEvent event) {
        if (isAnimFiltered) {
            LocalPlayerPatch playerpatch = ClientEngine.getInstance().getPlayerPatch();
            //only apply fix in EF battle mode
            if (playerpatch != null && playerpatch.isBattleMode()) {
                applyOffset(event);
            }
        } else {
            applyOffset(event);
        }
    }

    private static void applyOffset(RenderHandEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        assert player != null;
        // Clone the current transformation matrix
        Matrix4f transform = event.getPoseStack().last().pose();

        // if player is moving add additional y transformation
        float y = 0.0F;
        if (player.isMovingSlowly()) {
            y = crouchOffset;
        }

        // Check if the player is using a crossbow and apply transformations
        if (player.getItemBySlot(EquipmentSlot.MAINHAND).getItem() instanceof CrossbowItem) {
            // Adjust hand position to the left/right
            transform.translate(0.0F, crossbowOffset + y, 0.0F);
        }
        // Check if the player is using a bow and apply transformations
        if (player.isUsingItem() && player.getUseItem().getItem() instanceof BowItem) {
            // Adjust hand position to the bottom/top
            transform.translate(bowOffset, y, 0.0F);
        }
    }
}
