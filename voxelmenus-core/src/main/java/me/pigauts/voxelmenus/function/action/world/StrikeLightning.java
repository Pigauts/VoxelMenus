package me.pigauts.voxelmenus.function.action.world;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.*;

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
