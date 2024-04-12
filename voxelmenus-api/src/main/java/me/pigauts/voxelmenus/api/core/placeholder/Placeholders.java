package me.pigauts.voxelmenus.api.core.placeholder;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Placeholders {

    public static ItemMeta apply(ItemMeta meta, Placeholder placeholder) {
        return placeholder.apply(meta);
    }

    public static ItemStack apply(ItemStack item, Placeholder placeholder) {
        item.setItemMeta(apply(item.getItemMeta(), placeholder));
        return item;
    }

}
