package me.pigauts.voxelmenus.api.core;

import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

    private InventoryUtils() {}

    public static boolean isValidChestInventory(InventoryType storage, int size) {
        return storage == InventoryType.CHEST && size % 9 == 0 && size > 0 && size < 55;
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

    public static Inventory createInventory(Menu menu, InventoryMeta meta) {
        Inventory inventory = createInventory(meta.getTitle(), menu.getStorage(), menu.getSize());
//        inventory.setContents(meta.getButtons());
        return inventory;
    }

    public static Inventory createInventory(Menu menu) {
        return createInventory(menu.getStorage(), menu.getSize());
    }
}
