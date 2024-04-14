package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Condition;
import org.jetbrains.annotations.NotNull;

public record SwitchCase(@NotNull Condition condition, @NotNull Action action, boolean breakCycle) {

    public static final SwitchCase DEFAULT_BREAK = new SwitchCase(Condition.DEFAULT, Action.DEFAULT, true);

}
