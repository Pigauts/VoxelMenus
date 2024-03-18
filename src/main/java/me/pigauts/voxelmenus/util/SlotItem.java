package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.inventory.ItemStack;

public record SlotItem(ItemStack stack, int slot) {

    public static SlotItem deserialize(String raw) {
        Pair<String, Integer> pair = Pair.stringIntPairOf(raw);
        return pair == null ? null : new SlotItem(VoxelMenusPlugin.getPlugin().getItem(pair.key()), pair.value());
    }

}
