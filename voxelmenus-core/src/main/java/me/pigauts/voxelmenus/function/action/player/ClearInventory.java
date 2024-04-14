package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

public class ClearInventory implements Action {

    @Override
    public void execute(MenuPlayer player) {
        player.getInventory().clear();
    }

}
