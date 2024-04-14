package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.flag.Flag;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public class AddFlag implements Action {

    private final Flag flag;

    public AddFlag(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.addFlag(flag);
    }

}
