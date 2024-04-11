package me.pigauts.voxelmenus.core.runnable;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public abstract class MenusRunnable extends BukkitRunnable {

    private final static VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    public BukkitTask runTask() {
        return super.runTask(plugin);
    }

    public BukkitTask runTaskLater(long delay) {
        return super.runTaskLater(plugin, delay);
    }

    public BukkitTask runTaskTimer(long period) {
        return super.runTaskTimer(plugin, period, period);
    }

    public BukkitTask runTaskTimer(long delay, long period) {
        return super.runTaskTimer(plugin, delay, period);
    }

    public BukkitTask runTaskAsync() {
        return super.runTaskAsynchronously(plugin);
    }

    public BukkitTask runTaskLaterAsync(long delay) {
        return super.runTaskLaterAsynchronously(plugin, delay);
    }

    public BukkitTask runTaskTimerAsync(long period) {
        return super.runTaskTimerAsynchronously(plugin, period, period);
    }

    public BukkitTask runTaskTimerAsync(long delay, long period) {
        return super.runTaskTimerAsynchronously(plugin, delay, period);
    }

}
