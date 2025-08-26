package com.unknown.modpacktweak.event;

import com.p1nero.mo_falchion.MoFalchionMod;
import com.unknown.modpacktweak.ModTweakConfig;
import net.corruptdog.cdm.world.item.CDAddonItems;
import net.kenddie.fantasyarmor.item.FAItems;
import net.m3tte.tactical_imbuements.init.TacticalImbuementsModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import reascer.wom.world.item.WOMItems;
import org.violetmoon.quark.content.mobs.entity.Forgotten;
@Mod.EventBusSubscriber(modid = ModTweakConfig.MOD_ID)
public class LootAndAttributeEventHandler {

    @SubscribeEvent
    public static void modifyVanillaLootPools(LootTableLoadEvent event) {
        if (event.getName().equals(BuiltInLootTables.STRONGHOLD_CROSSING)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) WOMItems.RUINE.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(70)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_ANKLEBRACELET.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_CHAKRA.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_EARRINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_TASSET.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(30)).build());
        }

        if (event.getName().equals(BuiltInLootTables.STRONGHOLD_CORRIDOR)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.RUINE.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(40)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_FLAME.get()).setWeight(30)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_ANKLEBRACELET.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_CHAKRA.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_EARRINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.EMERALD_TASSET.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(30)).build());
        }

        if (event.getName().equals(BuiltInLootTables.SIMPLE_DUNGEON)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.AGONY.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(100)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_ARMBRACELET.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_CROWN.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_LEGBOTTOMSEAL.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_LEGTOPSEAL.get()).setWeight(1))
                    .add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_VENOM.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(20)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)MoFalchionMod.FALCHION.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)CDAddonItems.GREAT_TACHI.get()).setWeight(2)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(25)).build());
        }

        if (event.getName().equals(BuiltInLootTables.WOODLAND_MANSION)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.TORMENTED_MIND.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_VENOM.get()).setWeight(20)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_FLAME.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(20)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) FAItems.FOG_GUARD_BOOTS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.FOG_GUARD_LEGGINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.FOG_GUARD_CHESTPLATE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.FOG_GUARD_HELMET.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)CDAddonItems.GREAT_TACHI.get()).setWeight(3)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_ICE.get()).setWeight(15)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(12)).build());
        }

        if (event.getName().equals(BuiltInLootTables.PILLAGER_OUTPOST)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.TORMENTED_MIND.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_ICE.get()).setWeight(60)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(39)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) FAItems.RONIN_BOOTS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_LEGGINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_CHESTPLATE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_HELMET.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(30)).build());
        }

        if (event.getName().equals(BuiltInLootTables.END_CITY_TREASURE)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.ENDER_BLASTER.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_FLAME.get()).setWeight(30)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_ICE.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10)).build());
        }

        if (event.getName().equals(BuiltInLootTables.NETHER_BRIDGE)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.DEMON_SEAL.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_ICE.get()).setWeight(20)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(50)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_BELT.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_CHAINS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_MANICLE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_MASK.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(35)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)MoFalchionMod.FALCHION.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)CDAddonItems.GREAT_TACHI.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(20)).build());
        }

        if (event.getName().equals(BuiltInLootTables.BASTION_TREASURE)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.DEMON_SEAL.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_VENOM.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(40)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_BELT.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_CHAINS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_MANICLE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.NETHERITE_MASK.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(20)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(15)).build());
        }

        if (event.getName().equals(BuiltInLootTables.UNDERWATER_RUIN_SMALL)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.HERRSCHER.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(20)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(50)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.GESETZ.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(20)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(50)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) FAItems.RONIN_BOOTS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_LEGGINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_CHESTPLATE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_HELMET.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(10)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(20)).build());
        }

        if (event.getName().equals(BuiltInLootTables.UNDERWATER_RUIN_BIG)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.HERRSCHER.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(40)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.GESETZ.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(40)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) FAItems.RONIN_BOOTS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_LEGGINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_CHESTPLATE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_HELMET.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(30)).build());
        }

        if (event.getName().equals(BuiltInLootTables.STRONGHOLD_LIBRARY)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.MOONLESS.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_SPARKS.get()).setWeight(30)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(50)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_ARMBRACELET.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_CROWN.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_LEGBOTTOMSEAL.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)WOMItems.DIAMOND_LEGTOPSEAL.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_ICE.get()).setWeight(15)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(15)).build());
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) FAItems.RONIN_BOOTS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_LEGGINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_CHESTPLATE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_HELMET.get()).setWeight(1)).add(LootItem.lootTableItem(TacticalImbuementsModItems.FLASK_OF_FLAME.get()).setWeight(20)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10)).build());
        }

        if (event.getName().equals(BuiltInLootTables.SHIPWRECK_TREASURE)) {
            event.getTable().addPool(LootPool.lootPool().add(LootItem.lootTableItem((ItemLike) FAItems.RONIN_BOOTS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_LEGGINGS.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_CHESTPLATE.get()).setWeight(1)).add(LootItem.lootTableItem((ItemLike)FAItems.RONIN_HELMET.get()).setWeight(1)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(30)).build());
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void livingDropsEvent(LivingDropsEvent event) {
        if ("corruptfight".equals(event.getEntity().getLootTable().getNamespace())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onSpawnEvent(MobSpawnEvent.FinalizeSpawn event) {
        if (event.getEntity() instanceof Forgotten && !event.getEntity().getTags().contains("wom-bow-replaced")) {
            event.getEntity().addTag("wom-bow-replaced");
        }
    }
}

