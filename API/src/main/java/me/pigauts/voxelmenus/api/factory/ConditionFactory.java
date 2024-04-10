package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Condition;

@FunctionalInterface
public interface ConditionFactory extends ConfigFactory<Condition> {

    @Override
    Condition create(Config config);

}
