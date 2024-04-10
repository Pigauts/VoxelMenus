package me.pigauts.voxelmenus.api.player;

import me.pigauts.voxelmenus.api.core.collection.IdMap;
import me.pigauts.voxelmenus.api.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.api.menu.MenuEntries;
import me.pigauts.voxelmenus.api.menu.MenuMeta;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerCache {

    private ItemStack[] playerInventory = null;
    private final IdMap<Inventory> inventoriesCache = new IdMapImpl<>();
    private final IdMap<ItemStack> itemsCache = new IdMapImpl<>();
    private final IdMap<String> placeholdersCache = new IdMapImpl<>();
    private final IdMap<MenuView> viewsCache = new IdMapImpl<>();
    private final IdMap<MenuMeta> persistentMetaCache = new IdMapImpl<>();
    private final IdMap<MenuEntries> persistentEntriesCache = new IdMapImpl<>();

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

    public void cachePlaceholder(String placeholder, String value) {
        placeholdersCache.put(placeholder, value);
    }

    public String getCachedPlaceholder(String placeholder) {
        return placeholdersCache.get(placeholder);
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

    public MenuEntries getCachedEntries(String entriesId) {
        return persistentEntriesCache.get(entriesId);
    }
}
