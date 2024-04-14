package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.ScrollDirection;
import me.pigauts.voxelmenus.API.menu.view.AtlasView;
import org.jetbrains.annotations.NotNull;

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
