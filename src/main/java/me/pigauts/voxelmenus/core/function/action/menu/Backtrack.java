package me.pigauts.voxelmenus.core.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.core.function.action.Action;

public class Backtrack implements Action {

    @Override
    public void execute(MenuPlayer player) {
        if (!player.isViewingMenu()) return;
        MenuView previousView = player.getOpenView().getPreviousView();

        if (previousView != null) {
            player.openView(previousView);
        }
    }

}
