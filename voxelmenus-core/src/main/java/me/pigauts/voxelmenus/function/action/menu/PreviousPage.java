package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.view.PagedView;
import org.jetbrains.annotations.NotNull;

public class PreviousPage extends PagedViewAction {

    @Override
    public void execute(@NotNull MenuPlayer player, @NotNull PagedView view) {
        view.previousPage();
    }

}
