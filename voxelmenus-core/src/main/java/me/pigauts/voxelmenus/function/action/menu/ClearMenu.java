package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

public class ClearMenu implements Action {

    @Override
    public void execute(MenuPlayer player) {
        if (player.isViewingMenu()) {
            player.getOpenView().getInventory().clear();
        }
    }

}
