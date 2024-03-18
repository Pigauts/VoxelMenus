package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class GiveCachedItem implements Action {

    private final String name;

    public GiveCachedItem(String name) {
        this.name = name;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.giveItem(player.getCache().getCachedItem(name));
    }

}
