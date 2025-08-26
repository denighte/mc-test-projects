package com.unknown.modpacktweak.config;

import com.unknown.modpacktweak.ModTweakConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ModTweakConfig.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModelConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // Define the config values
    private static final ForgeConfigSpec.DoubleValue TEST;

    // The config spec will be built in the static block
    public static final ForgeConfigSpec CONFIG;

    static {
        // Push to "General Settings" category
        BUILDER.push("General Settings");

        // Define the bow/crossbow offset setting with a comment and range
        // Default value is 0.1, range between -10.0 and 10.0
        TEST = BUILDER
                .comment("Just a test value to know mod is loaded")
                .defineInRange("test", 0.0, -10.0, 10.0);
        // Pop the category
        BUILDER.pop();
        CONFIG = BUILDER.build();
    }
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
    }
}
