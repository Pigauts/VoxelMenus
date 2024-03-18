package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class SetFlight implements Action {

    private final boolean flight;

    public SetFlight(boolean flight) {
        this.flight = flight;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.asPlayer().setAllowFlight(flight);
    }

}
