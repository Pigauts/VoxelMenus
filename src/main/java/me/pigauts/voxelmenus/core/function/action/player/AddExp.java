package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class AddExp implements Action {

    private final int amount;

    public AddExp(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.addExp(amount);
    }

}
