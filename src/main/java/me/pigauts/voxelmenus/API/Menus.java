package me.pigauts.voxelmenus.API;

import me.pigauts.voxelmenus.API.factory.MenuFactory;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.Factories;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Menus {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    @NotNull
    public static MenusPlugin getPlugin() {
        return plugin;
    }

    @Nullable
    public static Menu createMenu(@NotNull ConfigSection config) {
        return Factories.createMenu(config);
    }


    public static void registerPlugin(@NotNull JavaPlugin plugin) {
        Validate.notNull(plugin, "Plugin can't be null");
    }

    public static void registerItem(@NotNull String id, @NotNull ItemStack item) {
        Validate.notNull(id, "Item id can't be null");
        Validate.notNull(item, "Itemstack can't be null");

        plugin.getItems().registerItem(id, item);
    }

    public static void registerMenuFactory(String id, MenuFactory factory) {
        plugin.getFactories().registerMenuFactory(id, factory);
    }

    public static Collection<MenuPlayer> getMenuPlayers() {
        return plugin.getPlayers().getAllPlayers();
    }

    public static List<MenuPlayer> getMenuPlayersList() {
        return new ArrayList<>(getMenuPlayers());
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

    public static Inventory createInventory(Menu menu, MenuMeta meta) {
        Inventory inventory = createInventory(meta.getTitle(), menu.getStorage(), menu.getSize());
        inventory.setContents(meta.getButtons());
        return inventory;
    }

    public static Inventory createInventory(Menu menu) {
        return createInventory(menu.getStorage(), menu.getSize());
    }



}
