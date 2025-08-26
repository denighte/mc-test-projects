package com.unknown.patch;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;
import yesman.epicfight.api.forgeevent.ModelBuildEvent;

@Mod(ModPatchMod.MOD_ID)
@Mod.EventBusSubscriber(modid = ModPatchMod.MOD_ID)
public class ModPatchMod {

    public static final String MOD_ID = "modpatch";
    public static final ForgeConfigSpec CONFIG;
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<String> PATCH_METHOD;
    public static final ForgeConfigSpec.DoubleValue CROSSBOW_OFFSET;
    public static final ForgeConfigSpec.DoubleValue BOW_OFFSET;
    public static final ForgeConfigSpec.DoubleValue CROUCH_OFFSET;
    public static boolean IS_FIX_APPLIED = false;

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MOD_ID);

    public static TagKey<Biome> SINKS_BOATS = TagKey.create(Registries.BIOME, new ResourceLocation(MOD_ID, "sinks_boats"));
    public static TagKey<EntityType<?>> SINKABLE_BOATS = TagKey.create(Registries.ENTITY_TYPE,  new ResourceLocation(MOD_ID,"sinkable"));

    static {
        // Push to "General Settings" category
        BUILDER.push("General Settings");
        BUILDER.push("Patched Renderers Settings");

        PATCH_METHOD = BUILDER
                .comment("Forgotten patch method, Allowed values: disabled, soft, hard. Soft patch will disable WOM patching of " +
                        "forgotten, Hard patch will work after WOM patch and makes sure forgotten always have a bow as secondary " +
                        "item, this will fix it constantly changing weapons.")
                .define("patchMethod", "soft");

        // Pop the category
        BUILDER.pop();
        BUILDER.push("Ranged Weapons Settings");
        CROSSBOW_OFFSET = BUILDER
                .comment("Adjust the crossbow offset, positive values move the crossbow to the top and vice versa. Default value is -0.1")
                .defineInRange("crossbowOffset", -0.1, -10.0, 10.0);
        BOW_OFFSET = BUILDER
                .comment("Adjust the bow offset, positive values move the bow to the right and vice versa. Default value is 0.1")
                .defineInRange("bowOffset", 0.1, -10.0, 10.0);
        CROUCH_OFFSET = BUILDER
                .comment("Adjust bow/crossbow offset when crouching, positive values move item to the top and vice versa. Default value is -0.2")
                .defineInRange("crouchOffset", -0.2, -10.0, 10.0);
        BUILDER.pop();
        BUILDER.pop();
        CONFIG = BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading event) {
        //Just a safeguard to load fixes only once, since I'm not familiar with forge lifecycle, probably redundant
        //or can be done in a better way
        if (!IS_FIX_APPLIED) {
            ForgottenPatchUtil.onLoad();
            IS_FIX_APPLIED = true;
        }
        RangedRenderFix.onLoad();
    }

    public ModPatchMod()
    {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        //ENCHANTMENTS.register(context.getModEventBus());
        context.getModEventBus().addListener(ModPatchMod::addEntitiesRenderer);
        context.getModEventBus().addListener(ModPatchMod::addEntitiesPatch);
        context.getModEventBus().addListener(ModPatchMod::addEntitiesArmature);
        context.registerConfig(ModConfig.Type.CLIENT, CONFIG, "renderpatch.toml");
        context.getModEventBus().addListener(ModPatchMod::onLoad);
    }

    public static void addEntitiesRenderer(PatchedRenderersEvent.Add event) {
        IllusionerPatchUtil.addIllusionerRenderer(event);
        ForgottenPatchUtil.addForgottenRenderer(event);
    }

    public static void addEntitiesPatch(EntityPatchRegistryEvent event) {
        IllusionerPatchUtil.addIllusionerPatch(event);
        ForgottenPatchUtil.addForgottenPatch(event);
    }

    public static void addEntitiesArmature(ModelBuildEvent.ArmatureBuild event) {
        IllusionerPatchUtil.addIllusionerArmature(event);
        ForgottenPatchUtil.addForgottenArmature(event);
    }
}
