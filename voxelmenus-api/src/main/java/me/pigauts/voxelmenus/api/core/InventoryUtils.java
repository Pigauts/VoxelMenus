package me.pigauts.voxelmenus.api.core;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

    private InventoryUtils() {}

    public static boolean isValidInventory(InventoryType storage, int size) {
        return storage == InventoryType.CHEST ? size % 9 == 0 && size > 0 && size <= 54 : size == storage.getDefaultSize();
    }

    public static Inventory createInventory(InventoryType storage) {
        return createInventory(storage.getDefaultTitle(), storage, storage.getDefaultSize());
    }

    public static Inventory createInventory(InventoryType storage, int size) {
        return createInventory(storage.getDefaultTitle(), storage, size);
    }

    public static Inventory createInventory(String title, InventoryType storage, int size) {
        if (storage == InventoryType.CHEST) {
            return Bukkit.createInventory(null, size, title);
        }
        return Bukkit.createInventory(null, storage, title);
    }

}
