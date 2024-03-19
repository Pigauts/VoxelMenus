package me.pigauts.voxelmenus.message;

import me.pigauts.voxelmenus.core.config.ConfigSection;
import org.jetbrains.annotations.Nullable;

public record Title(String title, String subtitle, int fadeIn, int stay, int fadeOut) {

    @Nullable
    public static Title fromConfig(ConfigSection config) {
        if (config == null) return null;
        return new Title(
                config.getNotNull(config::getColorString, "title"),
                config.getNotNull(config::getColorString, "subtitle"),
                config.getInt("fade-in", -1),
                config.getInt("stay", -1),
                config.getInt("fade-out", -1)
        );
    }

}
