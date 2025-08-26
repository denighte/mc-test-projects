package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class FACreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FantasyArmor.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FANTASY_ARMOR_TAB =
            CREATIVE_MODE_TABS.register(
                    "fa_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(FAItems.THIEF_HELMET.get()))
                            .title(Component.translatable("itemGroup." + FantasyArmor.MOD_ID + ".fa_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(FAItems.MOON_CRYSTAL.get());
                                pOutput.accept(FAItems.ECLIPSE_SOLDIER_HELMET.get());
                                pOutput.accept(FAItems.ECLIPSE_SOLDIER_CHESTPLATE.get());
                                pOutput.accept(FAItems.ECLIPSE_SOLDIER_LEGGINGS.get());
                                pOutput.accept(FAItems.ECLIPSE_SOLDIER_BOOTS.get());
                                pOutput.accept(FAItems.THIEF_HELMET.get());
                                pOutput.accept(FAItems.THIEF_CHESTPLATE.get());
                                pOutput.accept(FAItems.THIEF_LEGGINGS.get());
                                pOutput.accept(FAItems.THIEF_BOOTS.get());
                                pOutput.accept(FAItems.DARK_LORD_HELMET.get());
                                pOutput.accept(FAItems.DARK_LORD_CHESTPLATE.get());
                                pOutput.accept(FAItems.DARK_LORD_LEGGINGS.get());
                                pOutput.accept(FAItems.DARK_LORD_BOOTS.get());
                                pOutput.accept(FAItems.SUNSET_WINGS_HELMET.get());
                                pOutput.accept(FAItems.SUNSET_WINGS_CHESTPLATE.get());
                                pOutput.accept(FAItems.SUNSET_WINGS_LEGGINGS.get());
                                pOutput.accept(FAItems.SUNSET_WINGS_BOOTS.get());
                                pOutput.accept(FAItems.FOG_GUARD_HELMET.get());
                                pOutput.accept(FAItems.FOG_GUARD_CHESTPLATE.get());
                                pOutput.accept(FAItems.FOG_GUARD_LEGGINGS.get());
                                pOutput.accept(FAItems.FOG_GUARD_BOOTS.get());
                                pOutput.accept(FAItems.GILDED_HUNT_HELMET.get());
                                pOutput.accept(FAItems.GILDED_HUNT_CHESTPLATE.get());
                                pOutput.accept(FAItems.GILDED_HUNT_LEGGINGS.get());
                                pOutput.accept(FAItems.GILDED_HUNT_BOOTS.get());
                                pOutput.accept(FAItems.RONIN_HELMET.get());
                                pOutput.accept(FAItems.RONIN_CHESTPLATE.get());
                                pOutput.accept(FAItems.RONIN_LEGGINGS.get());
                                pOutput.accept(FAItems.RONIN_BOOTS.get());
                                pOutput.accept(FAItems.EVENING_GHOST_HELMET.get());
                                pOutput.accept(FAItems.EVENING_GHOST_CHESTPLATE.get());
                                pOutput.accept(FAItems.EVENING_GHOST_LEGGINGS.get());
                                pOutput.accept(FAItems.EVENING_GHOST_BOOTS.get());
                                pOutput.accept(FAItems.MALENIA_HELMET.get());
                                pOutput.accept(FAItems.MALENIA_CHESTPLATE.get());
                                pOutput.accept(FAItems.MALENIA_LEGGINGS.get());
                                pOutput.accept(FAItems.MALENIA_BOOTS.get());
                                pOutput.accept(FAItems.OLD_KNIGHT_HELMET.get());
                                pOutput.accept(FAItems.OLD_KNIGHT_CHESTPLATE.get());
                                pOutput.accept(FAItems.OLD_KNIGHT_LEGGINGS.get());
                                pOutput.accept(FAItems.OLD_KNIGHT_BOOTS.get());
                                pOutput.accept(FAItems.SILVER_KNIGHT_HELMET.get());
                                pOutput.accept(FAItems.SILVER_KNIGHT_CHESTPLATE.get());
                                pOutput.accept(FAItems.SILVER_KNIGHT_LEGGINGS.get());
                                pOutput.accept(FAItems.SILVER_KNIGHT_BOOTS.get());
                                pOutput.accept(FAItems.DRAGONSLAYER_HELMET.get());
                                pOutput.accept(FAItems.DRAGONSLAYER_CHESTPLATE.get());
                                pOutput.accept(FAItems.DRAGONSLAYER_LEGGINGS.get());
                                pOutput.accept(FAItems.DRAGONSLAYER_BOOTS.get());
                            })
                            .build()
            );


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
