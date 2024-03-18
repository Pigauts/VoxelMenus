package me.pigauts.voxelmenus.core.function.action.cache;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.holder.Placeholder;
import me.pigauts.voxelmenus.util.Pair;

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
