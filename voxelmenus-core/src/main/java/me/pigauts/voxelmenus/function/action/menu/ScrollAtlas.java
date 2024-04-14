package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.core.enums.*;
import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;
import org.jetbrains.annotations.*;

public class ScrollAtlas extends AtlasViewAction {

    private final ScrollDirection direction;
    private final int amount;

    public ScrollAtlas(ScrollDirection direction, int amount) {
        this.direction = direction;
        this.amount = amount;
    }

    @Override
    public void execute(@NotNull MenuPlayer player, @NotNull AtlasView view) {
        view.scroll(direction, amount);
    }

}
