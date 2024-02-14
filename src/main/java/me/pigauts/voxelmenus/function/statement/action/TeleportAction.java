package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.Location;

public class TeleportAction implements Action {

    private final Location destination;

    public TeleportAction(Location destination) {
        this.destination = destination;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.teleport(destination);
    }

}
