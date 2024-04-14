package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;
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
