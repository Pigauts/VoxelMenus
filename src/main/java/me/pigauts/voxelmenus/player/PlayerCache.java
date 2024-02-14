package me.pigauts.voxelmenus.player;

import me.pigauts.voxelmenus.menu.view.MenuView;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PlayerCache {

    private ItemStack[] playerInventory = null;
    private final Map<String, Inventory> inventoriesCache = new HashMap<>();
    private final Map<String, ItemStack> itemsCache = new HashMap<>();
    private final Map<String, String> placeholdersCache = new HashMap<>();
    private final Map<String, MenuView> viewsCache = new HashMap<>();

    public void cachePlayerInventory(ItemStack[] playerInventory) {
        this.playerInventory = playerInventory.clone();
    }

    public ItemStack[] getPlayerInventory() {
        return playerInventory;
    }

    public void flushPlayerInventory() {
        this.playerInventory = null;
    }

    public void cacheInventory(String name, Inventory inventory) {
        inventoriesCache.put(name, inventory);
    }

    public Inventory getCachedInventory(String name) {
        return inventoriesCache.get(name);
    }

    public void flushInventory(String name) {
        inventoriesCache.remove(name);
    }

    public void cacheItem(String name, ItemStack item) {
        itemsCache.put(name, item);
    }

    public ItemStack getCachedItem(String name) {
        return itemsCache.get(name);
    }

    public void flushItem(String name) {
        itemsCache.remove(name);
    }

    public void cachePlaceholder(String name, String placeholder) {
        placeholdersCache.put(name, placeholder);
    }

    public String getCachedPlaceholder(String name) {
        return placeholdersCache.get(name);
    }

    public void flushPlaceholder(String name) {
        placeholdersCache.remove(name);
    }

    public void cacheView(String name, MenuView view) {
        viewsCache.put(name, view);
    }

    public MenuView getCachedView(String name) {
        return viewsCache.get(name);
    }

    public void flushView(String name) {
        viewsCache.remove(name);
    }

}
