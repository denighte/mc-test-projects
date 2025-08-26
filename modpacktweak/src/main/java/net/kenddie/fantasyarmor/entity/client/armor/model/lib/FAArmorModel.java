package net.kenddie.fantasyarmor.entity.client.armor.model.lib;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.item.armor.lib.FAArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FAArmorModel <T extends FAArmorItem> extends GeoModel<T> {
    private final String modelPath;
    private final String texturePath;
    private final String animationPath;

    public FAArmorModel(String modelPath, String texturePath) {
        this(modelPath, texturePath, null);
    }

    public FAArmorModel(String modelPath, String texturePath, String animationPath) {
        this.modelPath = modelPath;
        this.texturePath = texturePath;
        this.animationPath = animationPath;
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return new ResourceLocation(FantasyArmor.MOD_ID, modelPath);
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return new ResourceLocation(FantasyArmor.MOD_ID, texturePath);
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        if (animationPath != null) {
            return new ResourceLocation(FantasyArmor.MOD_ID, animationPath);
        }
        return null;
    }
}