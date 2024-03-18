package me.pigauts.voxelmenus.core.factory;

import me.pigauts.voxelmenus.core.config.Config;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ConfigFactory<R> extends Factory<Config, R> {

    @Override
    R create(@NotNull Config config);

}
