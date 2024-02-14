package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.Bukkit;

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
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            action.execute(player);
        }, delay);
    }

}
