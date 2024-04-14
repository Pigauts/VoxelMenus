package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.view.PagedView;

public class NextPage extends PagedViewAction {

    @Override
    public void execute(MenuPlayer player, PagedView view) {
        view.nextPage();
    }

}
