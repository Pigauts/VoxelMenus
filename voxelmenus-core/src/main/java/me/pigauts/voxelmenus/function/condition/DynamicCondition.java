package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.holder.Placeholder;

public interface DynamicCondition {

    boolean isMet(MenuPlayer player, Placeholder parameter);

}
