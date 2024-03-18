package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.API.MenusPlugin;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.menu.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private final MenusPlugin plugin;

    private final Map<String, Button> customIcons = new HashMap<>();
    private final Map<String, FunctionSet> customFunctions = new HashMap<>();

    public ConfigManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public Button getIcon(String key) {
        return customIcons.get(key);
    }

    public FunctionSet getFunction(String key) {
        return customFunctions.get(key);
    }

}
