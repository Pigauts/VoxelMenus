package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class CloseMenuAction implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.closeMenu();
    }

}
