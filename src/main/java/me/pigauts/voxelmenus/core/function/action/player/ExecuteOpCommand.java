package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

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
