package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class SetExp implements Action {

    private final int amount;

    public SetExp(int amount) {
        this.amount = amount;
    }

    public SetExp(Config config) {
        this(config.getInt("SET_EXP"));
    }

    @Override
    public void execute(MenuPlayer player) {
        player.setExp(amount);
    }

}
