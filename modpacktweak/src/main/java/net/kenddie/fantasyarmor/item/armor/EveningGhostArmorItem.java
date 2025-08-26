package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.entity.client.armor.model.lib.FAArmorModel;
import net.kenddie.fantasyarmor.entity.client.armor.render.lib.FAArmorRenderer;
import net.kenddie.fantasyarmor.item.armor.lib.FAArmorAttributes;
import net.kenddie.fantasyarmor.item.armor.lib.FAArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EveningGhostArmorItem extends FAArmorItem {
    public EveningGhostArmorItem(Type type, FAArmorAttributes armorAttributes) {
        super(ArmorMaterials.IRON, type, armorAttributes);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    protected GeoArmorRenderer<? extends FAArmorItem> createArmorRenderer() {
        return new FAArmorRenderer<>(new FAArmorModel<>(
                "geo/evening_ghost_armor.geo.json",
                "textures/armor/evening_ghost_armor.png"
        ));
    }
}
