package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

public class ExecuteOpCommand implements Action {

    private final String command;

    public ExecuteOpCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.performCommandAsOp(command);
    }

}
