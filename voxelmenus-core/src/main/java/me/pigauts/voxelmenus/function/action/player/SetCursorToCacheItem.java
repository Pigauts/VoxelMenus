package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

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
