package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.user.MenuPlayer;

public class AddExpAction implements Action {

    private final int amount;

    public AddExpAction(int amount, boolean subtract) {
        this.amount = subtract ? -amount : amount;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.addExp(amount);
    }

}
