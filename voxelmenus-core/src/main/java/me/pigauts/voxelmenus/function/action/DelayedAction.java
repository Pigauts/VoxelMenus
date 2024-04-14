package me.pigauts.voxelmenus.function.action;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.core.runnable.MenusScheduler;

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
