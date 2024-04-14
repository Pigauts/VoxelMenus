package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

public class ClearInventory implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.getInventory().clear();
    }

}
