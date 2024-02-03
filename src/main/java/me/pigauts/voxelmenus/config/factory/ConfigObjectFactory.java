package me.pigauts.voxelmenus.config.factory;

import me.pigauts.voxelmenus.config.Config;

public abstract class ConfigObjectFactory<T> {

    public T createFromSection(Config section) { return null; }

    public T createFromKey(String key, Object value) { return null; }

}
