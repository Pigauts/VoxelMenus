package me.pigauts.voxelmenus.core.config;

import me.pigauts.voxelmenus.VoxelMenusPlugin;

public class ConfigurationException extends RuntimeException {

    private static final boolean DEBUG = VoxelMenusPlugin.getPlugin().getConfig().getBoolean("debug", false);

    public ConfigurationException(String message) {
        super(message, null, true, DEBUG);
    }

}
