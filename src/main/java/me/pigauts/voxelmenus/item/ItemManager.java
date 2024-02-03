package me.pigauts.voxelmenus.item;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.config.Config;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, ItemStack> items = new HashMap<>();

    public ItemManager(VoxelMenusPlugin menusPlugin) {
        this.plugin = menusPlugin;
    }

    public void load() {
        for (Config config : plugin.getConfigs("items"))
            for (String key : config.getKeys(false))
                items.put(key, config.getItemStack(key));
    }

    public void unload() {
        items.clear();
    }

    public ItemStack getItem(String name) {
        return items.get(name);
    }

}
