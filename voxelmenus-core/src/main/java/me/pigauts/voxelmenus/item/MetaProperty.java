package me.pigauts.voxelmenus.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface MetaProperty extends ItemProperty {

    @Override
    default void apply(ItemStack item) {
        if (item.hasItemMeta()) apply(item.getItemMeta());
    }

    @Override
    default void applyIfAbsent(ItemStack item) {
        if (item.hasItemMeta()) {
            applyIfAbsent(item.getItemMeta());
        }
    }

    void apply(ItemMeta meta);

    void applyIfAbsent(ItemMeta meta);

}
