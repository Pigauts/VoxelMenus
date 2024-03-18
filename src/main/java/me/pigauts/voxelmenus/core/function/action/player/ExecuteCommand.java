package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class ExecuteCommand implements Action {

    private final String command;

    public ExecuteCommand(String command) {
        this.command = command;
    }

    public ExecuteCommand(Config config) {
        this(config.getString("COMMAND"));
    }

    @Override
    public void execute(MenuPlayer player) {
        player.performCommand(command);
    }

}
