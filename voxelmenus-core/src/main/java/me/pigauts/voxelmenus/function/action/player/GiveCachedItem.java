package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

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
