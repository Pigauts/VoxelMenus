package me.pigauts.voxelmenus.core.function.action.menu;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class ClearMenu implements Action {

    @Override
    public void execute(MenuPlayer player) {
        MenuView view = player.getOpenView();
        if (view != null) {
            view.getTopInventory().clear();
        }
    }

}
