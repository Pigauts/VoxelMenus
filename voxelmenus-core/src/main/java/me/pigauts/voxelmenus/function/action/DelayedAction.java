package me.pigauts.voxelmenus.function.action;

import me.pigauts.voxelmenus.*;
import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import me.pigauts.voxelmenus.core.runnable.*;

public class DelayedAction implements Action {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    private final Action action;
    private final int delay;

    public DelayedAction(Action action, int delay) {
        this.action = action;
        this.delay = delay;
    }

    @Override
    public void execute(MenuPlayer player) {
        MenusScheduler.runTaskLater(delay, () -> action.execute(player));
    }

}
