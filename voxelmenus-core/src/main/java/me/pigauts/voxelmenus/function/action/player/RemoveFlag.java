package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

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
