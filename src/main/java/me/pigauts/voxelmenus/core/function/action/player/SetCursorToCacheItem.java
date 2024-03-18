package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class SetCursorToCacheItem implements Action {

    private final String name;

    public SetCursorToCacheItem(String name) {
        this.name = name;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.asPlayer().setItemOnCursor(player.getCache().getCachedItem(name));
    }

}
