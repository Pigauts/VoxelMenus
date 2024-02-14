package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;
import me.pigauts.voxelmenus.util.Weather;
import org.bukkit.World;

public class SetWeatherAction implements Action {

    private final Weather weather;
    private final int duration;

    public SetWeatherAction(Weather weather, int duration) {
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
            case RAIN:
                world.setStorm(true);
                world.setThundering(false);
            case THUNDER:
                world.setStorm(false);
                world.setThundering(true);
            case STORM:
                world.setStorm(true);
                world.setThundering(true);
        }
    }

}
