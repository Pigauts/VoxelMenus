package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;

public abstract class AtlasViewAction implements ViewAction<AtlasView> {

    @Override
    public void execute(MenuPlayer player) {
        player.getOpenView(AtlasView.class).ifPresent((view) -> execute(player, view));
    }

}
