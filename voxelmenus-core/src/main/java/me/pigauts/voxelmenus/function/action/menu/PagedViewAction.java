package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.view.PagedView;

public abstract class PagedViewAction implements ViewAction<PagedView> {

    @Override
    public void execute(MenuPlayer player) {
        player.getOpenView(PagedView.class).ifPresent((view) -> execute(player, view));
    }

}
