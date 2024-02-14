package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class UpdateViewAction implements Action {

    @Override
    public void execute(MenuPlayer player) {
        if (player.isViewingMenu()) {
            player.getOpenView().onUpdate();
        }
    }

}
