package me.pigauts.voxelmenus.entry;

import me.pigauts.voxelmenus.API.MenusPlugin;
import me.pigauts.voxelmenus.api.core.collection.IdMap;
import me.pigauts.voxelmenus.api.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.api.menu.MenuEntries;

public class EntryManager {

    private final MenusPlugin plugin;
    private final IdMap<MenuEntries> entries = new IdMapImpl<>();

    public EntryManager(MenusPlugin plugin) {
        this.plugin = plugin;
    }

    public MenuEntries getEntries(String entriesId) {
        return entries.get(entriesId);
    }


}
