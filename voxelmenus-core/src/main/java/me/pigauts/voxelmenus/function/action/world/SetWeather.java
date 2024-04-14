package me.pigauts.voxelmenus.function.action.world;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.util.Weather;
import me.pigauts.voxelmenus.util.WeatherCondition;
import org.bukkit.World;

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
