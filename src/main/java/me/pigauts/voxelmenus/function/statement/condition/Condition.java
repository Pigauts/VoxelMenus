package me.pigauts.voxelmenus.function.statement.condition;

import me.pigauts.voxelmenus.player.MenuPlayer;

public interface Condition {

    Condition DEFAULT = player -> true;

    boolean isMet(MenuPlayer player);

}
