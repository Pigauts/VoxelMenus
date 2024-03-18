package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class ClearInventory implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.getInventory().clear();
    }

}
