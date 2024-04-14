package me.pigauts.voxelmenus.entry;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.menu.MenuEntries;
import me.pigauts.voxelmenus.api.menu.MenuEntry;
import me.pigauts.voxelmenus.core.config.ConfigSection;

import java.util.ArrayList;
import java.util.List;

public class CustomEntries extends MenuEntries {

    public CustomEntries(boolean persistent) {
        super(persistent);
    }

    public static List<MenuEntry> fromConfig(ConfigSection config) {
        if (config == null) return null;

        List<MenuEntry> entries = new ArrayList<>();
        for (Config section : config.getSubSections("entries")) {
            MenuEntry entry = MenuEntry.fromConfig(section);
            if (entry != null) {
                entries.add(entry);
            }
        }

        return entries;
    }

}
