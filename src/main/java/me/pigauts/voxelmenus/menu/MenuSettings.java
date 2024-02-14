package me.pigauts.voxelmenus.menu;

import org.bukkit.event.inventory.InventoryType;

public record MenuSettings(InventoryType storage,
                           int size,
                           int refresh,
                           boolean keepOpen,
                           boolean lockBottom,
                           boolean lockEmpty) {

}
