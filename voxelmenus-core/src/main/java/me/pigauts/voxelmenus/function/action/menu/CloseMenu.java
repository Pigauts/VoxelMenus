package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

public class CloseMenu implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.closeView();
    }

}
