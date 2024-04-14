package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

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
