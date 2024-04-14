package me.pigauts.voxelmenus.function.action.world;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.*;

public class SetWeather implements Action {

    private final Weather weather;
    private final int duration;

    public SetWeather(WeatherCondition weatherCondition) {
        this(weatherCondition.weather(), weatherCondition.duration());
    }

    public SetWeather(Weather weather, int duration) {
        this.weather = weather;
        this.duration = duration;
    }

    @Override
    public void execute(MenuPlayer player) {
        World world = player.getWorld();

        world.setWeatherDuration(duration);
        world.setThunderDuration(duration);

        switch (weather) {
            case CLEAR:
                world.setStorm(false);
                world.setThundering(false);
                break;
            case RAIN:
                world.setStorm(true);
                world.setThundering(false);
                break;
            case THUNDER:
                world.setStorm(false);
                world.setThundering(true);
                break;
            case STORM:
                world.setStorm(true);
                world.setThundering(true);
                break;
        }
    }

}
