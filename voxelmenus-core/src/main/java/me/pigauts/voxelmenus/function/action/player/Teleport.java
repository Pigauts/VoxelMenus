package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.*;

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
