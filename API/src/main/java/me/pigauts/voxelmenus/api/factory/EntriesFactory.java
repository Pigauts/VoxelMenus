package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.menu.MenuEntryButtons;

@FunctionalInterface
public interface EntriesFactory extends ConfigFactory<MenuEntryButtons> {

    @Override
    MenuEntryButtons create(Config config);

}
