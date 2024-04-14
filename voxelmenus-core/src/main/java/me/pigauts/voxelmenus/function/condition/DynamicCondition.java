package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.api.core.placeholder.*;
import me.pigauts.voxelmenus.api.player.*;

public interface DynamicCondition {

    boolean isMet(MenuPlayer player, Placeholder parameter);

}
