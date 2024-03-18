package me.pigauts.voxelmenus.core.function.action.menu;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.menu.view.PagedMenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class NextPage implements Action {

    @Override
    public void execute(MenuPlayer player) {
        PagedMenuView view = player.getOpenView(PagedMenuView.class);
        if (view != null) {
            view.nextPage();
        }
    }

}
