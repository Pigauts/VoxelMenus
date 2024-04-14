package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;
import org.jetbrains.annotations.NotNull;

public interface ViewAction<T> extends Action {

    void execute(@NotNull MenuPlayer player, @NotNull T view);

}
