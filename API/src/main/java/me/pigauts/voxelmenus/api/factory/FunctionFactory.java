package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Function;

@FunctionalInterface
public interface FunctionFactory extends ConfigFactory<Function> {

    @Override
    Function create(Config config);

    default boolean matchSyntax(Config config) { return false; }

}
