package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.jetbrains.annotations.*;

public interface ViewAction<T> extends Action {

    void execute(@NotNull MenuPlayer player, @NotNull T view);

}
