package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;

public class NextPage extends PagedViewAction {

    @Override
    public void execute(MenuPlayer player, PagedView view) {
        view.nextPage();
    }

}
