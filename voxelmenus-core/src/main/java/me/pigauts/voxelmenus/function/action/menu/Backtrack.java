package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;

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
