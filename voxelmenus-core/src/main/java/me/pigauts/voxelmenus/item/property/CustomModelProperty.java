package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.item.MetaProperty;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomModelProperty implements MetaProperty {

    private final int customModel;

    public CustomModelProperty(int customModel) {
        this.customModel = customModel;
    }

    @Override
    public void apply(ItemMeta meta) {
        meta.setCustomModelData(customModel);
    }

    @Override
    public void applyIfAbsent(ItemMeta meta) {
        if (!meta.hasCustomModelData()) apply(meta);
    }

}
