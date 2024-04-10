package me.pigauts.voxelmenus.api.message;

import me.pigauts.voxelmenus.api.config.Config;
import org.jetbrains.annotations.Nullable;

public record Title(String title, String subtitle, int fadeIn, int stay, int fadeOut) {

    @Nullable
    public static Title fromConfig(Config config) {
        if (config == null) return null;
        return new Title(
                config.getString("title"),
                config.getString("subtitle"),
                config.getInt("fade-in", -1),
                config.getInt("stay", -1),
                config.getInt("fade-out", -1)
        );
    }

}
