package me.pigauts.voxelmenus.api.config;

import me.pigauts.voxelmenus.api.VoxelMenusAPI;

public class ConfigurationException extends RuntimeException {

    public ConfigurationException(String message) {
        super(message, null, true, VoxelMenusAPI.debug());
    }

}
