package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class SetFlightAction implements Action {

    private final boolean flight;

    public SetFlightAction(boolean flight) {
        this.flight = flight;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.asPlayer().setAllowFlight(flight);
    }

}
