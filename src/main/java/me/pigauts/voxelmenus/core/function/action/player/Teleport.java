package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.Location;

public class Teleport implements Action {

    private final Location destination;

    public Teleport(Location destination) {
        this.destination = destination;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.teleport(destination);
    }

}
