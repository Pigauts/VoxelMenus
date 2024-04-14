package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.menu.view.*;
import me.pigauts.voxelmenus.api.player.*;
import org.jetbrains.annotations.*;

public class PreviousPage extends PagedViewAction {

    @Override
    public void execute(@NotNull MenuPlayer player, @NotNull PagedView view) {
        view.previousPage();
    }

}
