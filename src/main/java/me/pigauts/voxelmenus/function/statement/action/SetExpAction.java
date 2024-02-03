package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.user.MenuPlayer;

public class SetExpAction implements Action {

    private final int amount;

    public SetExpAction(int amount) {
        this.amount = amount;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.setExp(amount);
    }

}
