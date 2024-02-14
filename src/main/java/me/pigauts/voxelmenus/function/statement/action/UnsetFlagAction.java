package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class UnsetFlagAction implements Action {

    private final String flag;

    public UnsetFlagAction(String flag) {
        this.flag = flag;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.unsetFlag(flag);
    }
    
}
