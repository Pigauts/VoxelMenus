package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class ClearInventoryAction implements Action {

    @Override
    public void execute(MenuPlayer player) {
        MenuView view = player.getOpenView();
        if (view != null) {
            view.getTopInventory().clear();
        }
    }

}
