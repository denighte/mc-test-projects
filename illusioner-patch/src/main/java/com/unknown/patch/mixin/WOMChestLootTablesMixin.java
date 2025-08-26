package com.unknown.patch.mixin;

import net.minecraftforge.event.LootTableLoadEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import reascer.wom.world.loot.WOMChestLootTables;

@Mixin(value = WOMChestLootTables.class, remap = false)
public class WOMChestLootTablesMixin {

    @Overwrite
    public static void modifyVanillaLootPools(LootTableLoadEvent event) {
        //disable wom loot tables modifications
    }
}
