package me.pigauts.voxelmenus.core.factory;

import me.pigauts.voxelmenus.core.config.Config;

@FunctionalInterface
public interface ConfigKeyFactory<R> extends BiFactory<Config, String, R> {

    @Override
    R create(Config config, String key);

}
