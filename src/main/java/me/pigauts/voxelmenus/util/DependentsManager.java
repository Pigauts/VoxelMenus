package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.API.MenusPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.ArrayList;
import java.util.List;

public class DependentsManager {




    private final MenusPlugin plugin;

    private final List<Plugin> dependentPlugins = new ArrayList<>();

    public DependentsManager(MenusPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        String pluginName = plugin.getName();

        for (Plugin loadedPlugin : Bukkit.getServer().getPluginManager().getPlugins()) {
            PluginDescriptionFile description = loadedPlugin.getDescription();

            if (description.getDepend().contains(pluginName) || description.getSoftDepend().contains(pluginName)) {
                dependentPlugins.add(loadedPlugin);
            }
        }

    }

}
