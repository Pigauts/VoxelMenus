package me.pigauts.voxelmenus.API;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.config.factory.menu.MenuFactory;
import me.pigauts.voxelmenus.menu.Menu;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Menus {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.get();

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

}
