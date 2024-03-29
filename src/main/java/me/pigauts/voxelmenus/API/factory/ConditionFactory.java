package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.function.condition.Condition;

@FunctionalInterface
public interface ConditionFactory extends ConfigFactory<Condition> {

    @Override
    Condition create(Config config);

}
