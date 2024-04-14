package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;

public abstract class PagedViewAction implements ViewAction<PagedView> {

    @Override
    public void execute(MenuPlayer player) {
        player.getOpenView(PagedView.class).ifPresent((view) -> execute(player, view));
    }

}
