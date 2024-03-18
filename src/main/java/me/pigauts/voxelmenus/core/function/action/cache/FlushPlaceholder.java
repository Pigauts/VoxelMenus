package me.pigauts.voxelmenus.core.function.action.cache;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

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
