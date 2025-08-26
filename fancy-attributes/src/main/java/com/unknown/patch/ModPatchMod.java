package com.unknown.patch;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;

@Mod(ModPatchMod.MOD_ID)
@Mod.EventBusSubscriber(modid = ModPatchMod.MOD_ID)
public class ModPatchMod {

    public static final String MOD_ID = "modpatch";


    public ModPatchMod()
    {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        //context.registerConfig(ModConfig.Type.CLIENT, CONFIG, "renderpatch.toml");
        //context.getModEventBus().addListener(ModPatchMod::onLoad);
    }

}
