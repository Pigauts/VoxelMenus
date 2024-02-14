package me.pigauts.voxelmenus.API;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.config.factory.menu.MenuFactory;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Menus {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    public static Menu createMenu(Config config) {
        return FactoryUtil.createMenu(config);
    }

    public static void registerPlugin(JavaPlugin plugin) {

    }

    public static void registerItem(String name, ItemStack item) {

    }

    public static void registerMenuFactory(String id, MenuFactory factory) {
        plugin.getFactory().registerMenuFactory(id, factory);
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



}
