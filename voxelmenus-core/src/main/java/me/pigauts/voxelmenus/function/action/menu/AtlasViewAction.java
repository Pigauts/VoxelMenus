package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.view.AtlasView;

public abstract class AtlasViewAction implements ViewAction<AtlasView> {

    @Override
    public void execute(MenuPlayer player) {
        player.getOpenView(AtlasView.class).ifPresent((view) -> execute(player, view));
    }

}
