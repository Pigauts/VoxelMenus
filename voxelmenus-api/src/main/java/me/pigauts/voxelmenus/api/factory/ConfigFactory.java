package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ConfigFactory<R> extends Factory<Config, R> {

    @Override
    R create(@NotNull Config config);

}
