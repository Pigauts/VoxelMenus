package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import me.pigauts.voxelmenus.core.config.*;

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
