package me.pigauts.voxelmenus.core.function.condition;

import me.pigauts.voxelmenus.API.MenuPlayer;

public interface Condition {

    Condition DEFAULT = player -> true;

    boolean isMet(MenuPlayer player);

}
