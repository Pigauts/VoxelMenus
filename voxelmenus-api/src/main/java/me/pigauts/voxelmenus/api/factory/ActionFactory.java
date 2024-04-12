package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Action;

@FunctionalInterface
public interface ActionFactory extends ConfigFactory<Action> {

    @Override
    Action create(Config config);

}


