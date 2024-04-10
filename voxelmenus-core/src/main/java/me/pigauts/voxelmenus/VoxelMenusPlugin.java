package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.api.VoxelMenus;
import org.bukkit.plugin.java.JavaPlugin;

public class VoxelMenusPlugin extends JavaPlugin implements VoxelMenus {

    private static VoxelMenus plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static VoxelMenus getPlugin() {
        return plugin;
    }

}
