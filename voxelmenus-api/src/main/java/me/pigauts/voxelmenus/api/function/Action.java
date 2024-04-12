package me.pigauts.voxelmenus.api.function;

import me.pigauts.voxelmenus.api.player.MenuPlayer;
import org.jetbrains.annotations.NotNull;

public interface Action {

    Action DEFAULT = player -> {};

    void execute(@NotNull MenuPlayer player);

}
