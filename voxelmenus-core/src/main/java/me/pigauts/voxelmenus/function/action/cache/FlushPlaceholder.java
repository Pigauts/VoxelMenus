package me.pigauts.voxelmenus.function.action.cache;

import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public class FlushPlaceholder implements Action {

    private final String placeholder;

    public FlushPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.getCache().flushPlaceholder(placeholder);
    }

}
