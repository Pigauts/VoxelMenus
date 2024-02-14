package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.event.menu.MenuCloseEvent;
import me.pigauts.voxelmenus.event.menu.MenuOpenEvent;
import me.pigauts.voxelmenus.event.menu.MenuUpdateEvent;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, Menu> menusByName = new HashMap<>();

    public MenuManager(VoxelMenusPlugin menusPlugin) {
        this.plugin = menusPlugin;
    }

    public void load() {
        for (Config config : plugin.getConfigs("menus")) {
            Menu menu = FactoryUtil.createMenu(config);

            if (menu == null) return;

            menusByName.put(menu.getName(), menu);
        }
    }

    public Menu getMenu(String name) {
        return menusByName.get(name);
    }

}
