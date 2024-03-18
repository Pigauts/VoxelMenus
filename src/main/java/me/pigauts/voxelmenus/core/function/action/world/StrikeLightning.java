package me.pigauts.voxelmenus.core.function.action.world;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.Location;

public class StrikeLightning implements Action {

    private final Location location;

    public StrikeLightning(Location location) {
        this.location = location;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.getWorld().strikeLightning(location == null ? player.getLocation() : location);
    }

}
