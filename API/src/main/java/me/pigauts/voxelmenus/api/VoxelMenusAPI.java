package me.pigauts.voxelmenus.api;

public class VoxelMenusAPI {

    private static VoxelMenus plugin;

    public static VoxelMenus getVoxelMenus() {
        return plugin;
    }

    public static void setPluginInstance(VoxelMenus plugin) {
        if (VoxelMenusAPI.plugin != null) {
            throw new UnsupportedOperationException("VoxelMenus api instance has already been initialized");
        }
        VoxelMenusAPI.plugin = plugin;
    }

}
