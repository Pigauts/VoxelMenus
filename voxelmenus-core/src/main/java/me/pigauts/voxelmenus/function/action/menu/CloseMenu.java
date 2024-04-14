package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

public class CloseMenu implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.closeView();
    }

}
