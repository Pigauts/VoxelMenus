package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.Util;
import org.jetbrains.annotations.Nullable;

public record WeatherCondition(Weather weather, int duration) {

    @Nullable
    public static WeatherCondition deserialize(String raw) {
        Pair<String, Integer> pair = Pair.stringIntPairOf(raw);
        if (pair == null || !Util.isEnum(Weather.class, pair.key())) return null;
        return new WeatherCondition(Util.getEnum(Weather.class, pair.key()), pair.value());
    }

}
