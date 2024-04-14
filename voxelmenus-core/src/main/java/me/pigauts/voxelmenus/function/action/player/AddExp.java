package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

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
