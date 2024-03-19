package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.function.action.Action;

@FunctionalInterface
public interface ActionFactory extends ConfigFactory<Action> {

    @Override
    Action create(Config config);

}


