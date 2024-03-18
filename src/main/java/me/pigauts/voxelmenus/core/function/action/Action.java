package me.pigauts.voxelmenus.core.function.action;

import me.pigauts.voxelmenus.API.MenuPlayer;

public interface Action {

    Action DEFAULT = player -> {};

    void execute(MenuPlayer player);

}
