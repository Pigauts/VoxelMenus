package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.user.MenuPlayer;

public class ClearInventoryAction implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.getInventory().clear();
    }

}
