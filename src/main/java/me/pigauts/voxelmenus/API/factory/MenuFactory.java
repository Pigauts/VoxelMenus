package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;

@FunctionalInterface
public interface MenuFactory extends ConfigFactory<Menu> {

    @Override
    Menu create(ConfigSection config);

}
