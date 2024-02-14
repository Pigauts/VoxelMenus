package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.Location;

public class StrikeLightningAction implements Action {

    private final Location location;

    public StrikeLightningAction(Location location) {
        this.location = location;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.getWorld().strikeLightning(location == null ? player.getLocation() : location);
    }

}
