package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.menu.view.PageMenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class NextPageAction implements Action {

    @Override
    public void execute(MenuPlayer player) {
        PageMenuView view = player.getOpenView(PageMenuView.class);
        if (view != null) {
            view.nextPage();
        }
    }

}
