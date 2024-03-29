package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.menu.widget.entries.MenuEntries;

@FunctionalInterface
public interface EntriesFactory extends ConfigFactory<MenuEntries> {

    @Override
    MenuEntries create(ConfigSection config);

}
