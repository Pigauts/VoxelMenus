package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.API.Function;

@FunctionalInterface
public interface FunctionFactory extends ConfigFactory<Function> {

    @Override
    Function create(ConfigSection config);

    default boolean matchSyntax(ConfigSection config) { return false; }

}
