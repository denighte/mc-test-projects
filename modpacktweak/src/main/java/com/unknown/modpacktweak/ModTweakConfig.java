package com.unknown.modpacktweak;

import com.alekiponi.alekiships.common.entity.CannonballEntity;
import com.unknown.modpacktweak.config.ModelConfig;
import net.kenddie.fantasyarmor.item.FACreativeModTabs;
import net.kenddie.fantasyarmor.item.FAItems;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModTweakConfig.MOD_ID)
public class ModTweakConfig
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "modpacktweak";
    public ModTweakConfig()
    {
        FMLJavaModLoadingContext context = FMLJavaModLoadingContext.get();
        context.registerConfig(ModConfig.Type.CLIENT, ModelConfig.CONFIG, "modpacktweak.toml");
        MinecraftForge.EVENT_BUS.addListener((ExplosionEvent.Detonate event) -> {
            Explosion explosion = event.getExplosion();
            if (explosion.getExploder() instanceof CannonballEntity) {
                explosion.clearToBlow();
            }
        });
        FAItems.register(context.getModEventBus());
        FACreativeModTabs.register(context.getModEventBus());


    }
}
