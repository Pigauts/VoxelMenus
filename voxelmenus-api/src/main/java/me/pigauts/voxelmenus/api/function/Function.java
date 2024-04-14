package me.pigauts.voxelmenus.api.function;

import me.pigauts.voxelmenus.api.player.MenuPlayer;

public interface Function {

    Function DEFAULT = player -> {};

    void run(MenuPlayer player);

}
