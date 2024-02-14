package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class ClearPlayerInventoryAction implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.getInventory().clear();
    }

}
