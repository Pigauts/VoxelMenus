package me.pigauts.voxelmenus.core.builder;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.config.Config;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.NotNull;

public abstract class Builder<T> {

    protected static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    public Builder() {}

    public Builder(@NotNull Config config) {
        Validate.notNull(config, "Config cannot be null");
    }

    public abstract T build();

}
