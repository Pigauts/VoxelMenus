package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.item.MetaProperty;
import org.bukkit.inventory.meta.ItemMeta;

public class DisplayNameProperty implements MetaProperty {

    private final String name;

    public DisplayNameProperty(String name) {
        this.name = name;
    }

    @Override
    public void apply(ItemMeta meta) {
        meta.setDisplayName(name);
    }

    @Override
    public void applyIfAbsent(ItemMeta meta) {
        if (!meta.hasDisplayName()) apply(meta);
    }

}
