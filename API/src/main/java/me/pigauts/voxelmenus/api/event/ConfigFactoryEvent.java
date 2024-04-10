package me.pigauts.voxelmenus.api.event;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;

public abstract class ConfigFactoryEvent<T> extends FactoryEvent<T> {

    private final Config config;

    public ConfigFactoryEvent(Config config, ConfigFactory<T> factory) {
        super(factory == null ? null : factory.create(config));
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

}
