package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.item.armor.DarkLordArmorItem;
import net.kenddie.fantasyarmor.item.armor.DragonSlayerArmorItem;
import net.kenddie.fantasyarmor.item.armor.EclipseSoldierArmorItem;
import net.kenddie.fantasyarmor.item.armor.EveningGhostArmorItem;
import net.kenddie.fantasyarmor.item.armor.FogGuardArmorItem;
import net.kenddie.fantasyarmor.item.armor.GildedHuntArmorItem;
import net.kenddie.fantasyarmor.item.armor.MaleniaArmorItem;
import net.kenddie.fantasyarmor.item.armor.OldKnightArmorItem;
import net.kenddie.fantasyarmor.item.armor.RoninArmorItem;
import net.kenddie.fantasyarmor.item.armor.SilverKnightArmorItem;
import net.kenddie.fantasyarmor.item.armor.SunsetWingsArmorItem;
import net.kenddie.fantasyarmor.item.armor.ThiefArmorItem;
import net.kenddie.fantasyarmor.item.armor.lib.FAArmorAttributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public final class FAItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FantasyArmor.MOD_ID);

    public static final RegistryObject<Item> MOON_CRYSTAL = ITEMS.register("moon_crystal", () -> new Item(new Item.Properties()));

    // ECLIPSE_SOLDIER
    public static final RegistryObject<Item> ECLIPSE_SOLDIER_HELMET = ITEMS.register("eclipse_soldier_helmet", () ->
            new EclipseSoldierArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
            .armor(2.5)
            .armorToughness(1.0)
            .knockbackResistance(0.05)
            .maxStamina(1.0)
            .stunArmor(1.0)
            .build()));

    public static final RegistryObject<Item> ECLIPSE_SOLDIER_CHESTPLATE = ITEMS.register("eclipse_soldier_chestplate", () ->
            new EclipseSoldierArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
            .armor(6.5)
            .armorToughness(1.0)
            .knockbackResistance(0.05)
            .maxStamina(2.0)
            .stunArmor(3.0)
            .build()));

    public static final RegistryObject<Item> ECLIPSE_SOLDIER_LEGGINGS = ITEMS.register("eclipse_soldier_leggings", () ->
            new EclipseSoldierArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
            .armor(5.5)
            .armorToughness(1.0)
            .knockbackResistance(0.05)
            .maxStamina(2.0)
            .stunArmor(2.5)
            .build()));

    public static final RegistryObject<Item> ECLIPSE_SOLDIER_BOOTS = ITEMS.register("eclipse_soldier_boots", () ->
            new EclipseSoldierArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
            .armor(2.5)
            .armorToughness(1.0)
            .knockbackResistance(0.05)
            .maxStamina(1.0)
            .stunArmor(1.0)
            .build()));

    // THIEF
    public static final RegistryObject<Item> THIEF_HELMET = ITEMS.register("thief_helmet", () ->
            new ThiefArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(1.5)
                    .armorToughness(2.0)
                    .maxStamina(2.0)
                    .stunArmor(1.0)
                    .expGain(0.2)
                    .build()));

    public static final RegistryObject<Item> THIEF_CHESTPLATE = ITEMS.register("thief_chestplate", () ->
            new ThiefArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(4.0)
                    .armorToughness(2.0)
                    .maxStamina(10.0)
                    .stunArmor(3.0)
                    .drawSpeed(0.1)
                    .luck(0.5)
                    .build()));

    public static final RegistryObject<Item> THIEF_LEGGINGS = ITEMS.register("thief_leggings", () ->
            new ThiefArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(2.0)
                    .armorToughness(2.0)
                    .maxStamina(4.0)
                    .staminaRegen(0.1)
                    .stunArmor(2.5)
                    .build()));

    public static final RegistryObject<Item> THIEF_BOOTS = ITEMS.register("thief_boots", () ->
            new ThiefArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(1.5)
                    .armorToughness(2.0)
                    .maxStamina(4.0)
                    .movementSpeed(0.1)
                    .stunArmor(1.0)
                    .build()));

    // DARK_LORD
    public static final RegistryObject<Item> DARK_LORD_HELMET = ITEMS.register("dark_lord_helmet", () ->
            new DarkLordArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(2.5)
                    .armorToughness(3.0)
                    .maxHealth(4.0)
                    .build()));

    public static final RegistryObject<Item> DARK_LORD_CHESTPLATE = ITEMS.register("dark_lord_chestplate", () ->
            new DarkLordArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(6.0)
                    .armorToughness(3.0)
                    .lifeSteal(0.01)
                    .build()));

    public static final RegistryObject<Item> DARK_LORD_LEGGINGS = ITEMS.register("dark_lord_leggings", () ->
            new DarkLordArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(5.0)
                    .armorToughness(3.0)
                    .attackDamage(0.1)
                    .build()));

    public static final RegistryObject<Item> DARK_LORD_BOOTS = ITEMS.register("dark_lord_boots", () ->
            new DarkLordArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(2.5)
                    .armorToughness(3.0)
                    .healingReceived(0.1)
                    .build()));

    // SUNSET_WINGS
    public static final RegistryObject<Item> SUNSET_WINGS_HELMET = ITEMS.register("sunset_wings_helmet", () ->
            new SunsetWingsArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .attackDamage(0.05)
                    .build()));

    public static final RegistryObject<Item> SUNSET_WINGS_CHESTPLATE = ITEMS.register("sunset_wings_chestplate", () ->
            new SunsetWingsArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(8.0)
                    .armorToughness(3.0)
                    .attackDamage(0.05)
                    .build()));

    public static final RegistryObject<Item> SUNSET_WINGS_LEGGINGS = ITEMS.register("sunset_wings_leggings", () ->
            new SunsetWingsArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(6.0)
                    .armorToughness(3.0)
                    .attackDamage(0.05)
                    .build()));

    public static final RegistryObject<Item> SUNSET_WINGS_BOOTS = ITEMS.register("sunset_wings_boots", () ->
            new SunsetWingsArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .attackDamage(0.05)
                    .build()));

    // FOG_GUARD (only for mobs)
    public static final RegistryObject<Item> FOG_GUARD_HELMET = ITEMS.register("fog_guard_helmet", () ->
            new FogGuardArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(2.5)
                    .lifeSteal(0.01)
                    .armorToughness(2.0)
                    .build()));

    public static final RegistryObject<Item> FOG_GUARD_CHESTPLATE = ITEMS.register("fog_guard_chestplate", () ->
            new FogGuardArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(7.0)
                    .lifeSteal(0.01)
                    .armorToughness(2.0)
                    .build()));

    public static final RegistryObject<Item> FOG_GUARD_LEGGINGS = ITEMS.register("fog_guard_leggings", () ->
            new FogGuardArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(4.0)
                    .armorToughness(2.0)
                    .lifeSteal(0.01)
                    .build()));

    public static final RegistryObject<Item> FOG_GUARD_BOOTS = ITEMS.register("fog_guard_boots", () ->
            new FogGuardArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(2.5)
                    .lifeSteal(0.01)
                    .armorToughness(2.0)
                    .build()));

    // GILDED_HUNT
    public static final RegistryObject<Item> GILDED_HUNT_HELMET = ITEMS.register("gilded_hunt_helmet", () ->
            new GildedHuntArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(3.5)
                    .armorToughness(5.0)
                    .stunArmor(0.5)
                    .knockbackResistance(0.1)
                    .build()));

    public static final RegistryObject<Item> GILDED_HUNT_CHESTPLATE = ITEMS.register("gilded_hunt_chestplate", () ->
            new GildedHuntArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(10.0)
                    .armorToughness(5.0)
                    .stunArmor(1.5)
                    .knockbackResistance(0.1)
                    .build()));

    public static final RegistryObject<Item> GILDED_HUNT_LEGGINGS = ITEMS.register("gilded_hunt_leggings", () ->
            new GildedHuntArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(7.0)
                    .armorToughness(5.0)
                    .stunArmor(1.0)
                    .knockbackResistance(0.1)
                    .build()));

    public static final RegistryObject<Item> GILDED_HUNT_BOOTS = ITEMS.register("gilded_hunt_boots", () ->
            new GildedHuntArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(3.5)
                    .armorToughness(5.0)
                    .stunArmor(0.5)
                    .knockbackResistance(0.1)
                    .build()));

    // RONIN
    public static final RegistryObject<Item> RONIN_HELMET = ITEMS.register("ronin_helmet", () ->
            new RoninArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(2.0)
                    .armorToughness(1.5)
                    .maxStamina(5.0)
                    .build()));

    public static final RegistryObject<Item> RONIN_CHESTPLATE = ITEMS.register("ronin_chestplate", () ->
            new RoninArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(6.0)
                    .armorToughness(1.5)
                    .maxStamina(5.0)
                    .build()));

    public static final RegistryObject<Item> RONIN_LEGGINGS = ITEMS.register("ronin_leggings", () ->
            new RoninArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(4.0)
                    .armorToughness(1.5)
                    .maxStamina(5.0)
                    .build()));

    public static final RegistryObject<Item> RONIN_BOOTS = ITEMS.register("ronin_boots", () ->
            new RoninArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(2.0)
                    .armorToughness(1.5)
                    .maxStamina(5.0)
                    .build()));

    //TODO: assign values

    // DRAGONSLAYER (only for mobs)
    public static final RegistryObject<Item> DRAGONSLAYER_HELMET = ITEMS.register("dragonslayer_helmet", () ->
            new DragonSlayerArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .critChance(0.05)
                    .build()));

    public static final RegistryObject<Item> DRAGONSLAYER_CHESTPLATE = ITEMS.register("dragonslayer_chestplate", () ->
            new DragonSlayerArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(8.0)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .critChance(0.1)
                    .build()));

    public static final RegistryObject<Item> DRAGONSLAYER_LEGGINGS = ITEMS.register("dragonslayer_leggings", () ->
            new DragonSlayerArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(6.0)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .critChance(0.05)
                    .build()));

    public static final RegistryObject<Item> DRAGONSLAYER_BOOTS = ITEMS.register("dragonslayer_boots", () ->
            new DragonSlayerArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .critChance(0.05)
                    .build()));

    // EVENING_GHOST (only for mobs)
    public static final RegistryObject<Item> EVENING_GHOST_HELMET = ITEMS.register("evening_ghost_helmet", () ->
            new EveningGhostArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(1.5)
                    .armorToughness(3.0)
                    .critChance(0.05)
                    .build()));

    public static final RegistryObject<Item> EVENING_GHOST_CHESTPLATE = ITEMS.register("evening_ghost_chestplate", () ->
            new EveningGhostArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(4.0)
                    .armorToughness(3.0)
                    .critChance(0.05)
                    .critDamage(0.2)
                    .attackSpeed(0.1)
                    .build()));

    public static final RegistryObject<Item> EVENING_GHOST_LEGGINGS = ITEMS.register("evening_ghost_leggings", () ->
            new EveningGhostArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(2.5)
                    .armorToughness(3.0)
                    .critChance(0.05)
                    .attackSpeed(0.05)
                    .build()));

    public static final RegistryObject<Item> EVENING_GHOST_BOOTS = ITEMS.register("evening_ghost_boots", () ->
            new EveningGhostArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(1.5)
                    .armorToughness(3.0)
                    .critChance(0.05)
                    .movementSpeed(0.2)
                    .build()));


    // MALENIA
    public static final RegistryObject<Item> MALENIA_HELMET = ITEMS.register("malenia_helmet", () ->
            new MaleniaArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(2.0)
                    .armorToughness(3.0)
                    .maxHealth(6.0)
                    .stunArmor(1.0)
                    .maxStamina(5.0)
                    .build()));

    public static final RegistryObject<Item> MALENIA_CHESTPLATE = ITEMS.register("malenia_chestplate", () ->
            new MaleniaArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(5.0)
                    .armorToughness(3.0)
                    .critChance(0.03)
                    .critDamage(0.1)
                    .maxStamina(5.0)
                    .staminaRegen(0.2)
                    .stunArmor(3.5)
                    .build()));

    public static final RegistryObject<Item> MALENIA_LEGGINGS = ITEMS.register("malenia_leggings", () ->
            new MaleniaArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .critChance(0.02)
                    .maxHealth(2.0)
                    .maxStamina(5.0)
                    .stunArmor(3.0)
                    .build()));

    public static final RegistryObject<Item> MALENIA_BOOTS = ITEMS.register("malenia_boots", () ->
            new MaleniaArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(1.0)
                    .armorToughness(3.0)
                    .maxHealth(2.0)
                    .movementSpeed(0.1)
                    .maxStamina(5.0)
                    .stunArmor(1.0)
                    .build()));

    // OLD KNIGHT
    public static final RegistryObject<Item> OLD_KNIGHT_HELMET = ITEMS.register("old_knight_helmet", () ->
            new OldKnightArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(2.0)
                    .stunArmor(0.5)
                    .attackDamage(0.05)
                    .maxStamina(5.0)
                    .armorToughness(2.0)
                    .build()));

    public static final RegistryObject<Item> OLD_KNIGHT_CHESTPLATE = ITEMS.register("old_knight_chestplate", () ->
            new OldKnightArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(6.5)
                    .stunArmor(1.5)
                    .critDamage(0.05)
                    .maxStamina(5.0)
                    .armorToughness(2.0)
                    .build()));

    public static final RegistryObject<Item> OLD_KNIGHT_LEGGINGS = ITEMS.register("old_knight_leggings", () ->
            new OldKnightArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(5.5)
                    .stunArmor(1.0)
                    .critChance(0.02)
                    .maxStamina(5.0)
                    .armorToughness(2.0)
                    .build()));

    public static final RegistryObject<Item> OLD_KNIGHT_BOOTS = ITEMS.register("old_knight_boots", () ->
            new OldKnightArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(2.0)
                    .stunArmor(0.5)
                    .luck(0.5)
                    .knockbackResistance(0.1)
                    .maxStamina(5.0)
                    .armorToughness(2.0)
                    .build()));

    // SILVER KNIGHT (for mobs only)
    public static final RegistryObject<Item> SILVER_KNIGHT_HELMET = ITEMS.register("silver_knight_helmet", () ->
            new SilverKnightArmorItem(ArmorItem.Type.HELMET, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .stunArmor(1.5)
                    .overheal(0.02)
                    .build()));

    public static final RegistryObject<Item> SILVER_KNIGHT_CHESTPLATE = ITEMS.register("silver_knight_chestplate", () ->
            new SilverKnightArmorItem(ArmorItem.Type.CHESTPLATE, FAArmorAttributes.builder()
                    .armor(8.5)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .stunArmor(4.0)
                    .critChance(0.1)
                    .lifeSteal(0.04)
                    .overheal(0.03)
                    .build()));

    public static final RegistryObject<Item> SILVER_KNIGHT_LEGGINGS = ITEMS.register("silver_knight_leggings", () ->
            new SilverKnightArmorItem(ArmorItem.Type.LEGGINGS, FAArmorAttributes.builder()
                    .armor(6.5)
                    .armorToughness(3.0)
                    .knockbackResistance(0.1)
                    .overheal(0.03)
                    .stunArmor(3.0)
                    .build()));

    public static final RegistryObject<Item> SILVER_KNIGHT_BOOTS = ITEMS.register("silver_knight_boots", () ->
            new SilverKnightArmorItem(ArmorItem.Type.BOOTS, FAArmorAttributes.builder()
                    .armor(3.0)
                    .armorToughness(3.0)
                    .overheal(0.02)
                    .movementSpeed(0.1)
                    .knockbackResistance(0.1)
                    .stunArmor(1.5)
                    .build()));


    private FAItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
