package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class RemoveFlag implements Action {

    private final String flag;

    public RemoveFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.removeFlag(flag);
    }

}
