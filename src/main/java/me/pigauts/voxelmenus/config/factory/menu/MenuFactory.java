package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.menu.Menu;

public interface MenuFactory {

    Menu createMenu(Config config);

}
