package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

public class ExecuteCommand implements Action {

    private final String command;

    public ExecuteCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.performCommand(command);
    }

}
