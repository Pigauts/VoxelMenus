package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class SetFlagAction implements Action {

    private final String flag;

    public SetFlagAction(String flag) {
        this.flag = flag;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.setFlag(flag);
    }

}
