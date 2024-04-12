package me.pigauts.voxelmenus.api.function;

import me.pigauts.voxelmenus.api.player.MenuPlayer;

public interface Condition {

    Condition DEFAULT = player -> true;

    boolean isMet(MenuPlayer player);

}
