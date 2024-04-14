package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.core.config.ConfigSection;

public class SetExp implements Action {

    private final int amount;

    public SetExp(int amount) {
        this.amount = amount;
    }

    public SetExp(ConfigSection config) {
        this(config.getInt("SET_EXP"));
    }

    @Override
    public void execute(MenuPlayer player) {
        player.setExp(amount);
    }

}
