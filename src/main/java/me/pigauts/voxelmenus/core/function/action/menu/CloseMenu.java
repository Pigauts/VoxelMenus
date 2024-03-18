package me.pigauts.voxelmenus.core.function.action.menu;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class CloseMenu implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.closeMenu();
    }

}
