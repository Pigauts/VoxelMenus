package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public class SimpleFunction implements Function {

    private final Action action;

    public SimpleFunction(Action action) {
        this.action = action;
    }

    @Override
    public void run(MenuPlayer player) {
        action.execute(player);
    }

}
