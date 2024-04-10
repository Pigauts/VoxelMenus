package me.pigauts.voxelmenus.item;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.config.Config;
import org.bukkit.inventory.ItemStack;

import java.util.*;

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

    public List<ItemStack> getItems(Collection<String> itemIds) {
        List<ItemStack> items = new ArrayList<>();

        for (String itemId : itemIds) {
            ItemStack item = this.items.get(itemId);
            if (item != null) {
                items.add(item);
            }
        }

        return items;
    }

    public void registerItem(String id, ItemStack item) {
        items.put(id, item);
    }

}
