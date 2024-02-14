package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class CommandAction implements Action {

    private final String command;

    public CommandAction(String command) {
        this.command = command;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.performCommand(command);
    }

}
