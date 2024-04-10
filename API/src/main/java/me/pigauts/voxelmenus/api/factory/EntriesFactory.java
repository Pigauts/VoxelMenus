package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.menu.MenuEntries;

@FunctionalInterface
public interface EntriesFactory extends ConfigFactory<MenuEntries> {

    @Override
    MenuEntries create(Config config);

}
