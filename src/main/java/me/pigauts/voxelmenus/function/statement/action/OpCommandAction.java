package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class OpCommandAction implements Action {

    private final String command;

    public OpCommandAction(String command) {
        this.command = command;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.performCommandAsOp(command);
    }

}
