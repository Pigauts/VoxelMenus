package me.pigauts.voxelmenus.function.action.cache;

import me.pigauts.voxelmenus.api.core.placeholder.Placeholder;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public class CachePlaceholder implements Action {

    private final Placeholder placeholder;

    public CachePlaceholder(Placeholder placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.getCache().cachePlaceholder(placeholder.id(), placeholder.value().toString());
    }

}
