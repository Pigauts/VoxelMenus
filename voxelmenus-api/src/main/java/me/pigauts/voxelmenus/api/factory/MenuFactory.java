package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.menu.Menu;

@FunctionalInterface
public interface MenuFactory extends ConfigFactory<Menu> {

    @Override
    Menu create(Config config);

}
