package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.Factories;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, Menu> menusByName = new HashMap<>();

    public MenuManager(VoxelMenusPlugin menusPlugin) {
        this.plugin = menusPlugin;
    }

    public void load() {
        for (ConfigSection config : plugin.getConfigs("menus")) {
            Menu menu = Factories.createMenu(config);
            if (menu == null) continue;

            menusByName.put(menu.getName(), menu);
        }
    }

    public Menu getMenu(String name) {
        return menusByName.get(name);
    }

}
