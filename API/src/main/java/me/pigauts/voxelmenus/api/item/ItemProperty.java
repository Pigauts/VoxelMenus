package me.pigauts.voxelmenus.api.item;

import org.bukkit.inventory.ItemStack;

public interface ItemProperty {

    void apply(ItemStack item);

    void applyIfAbsent(ItemStack item);

}
