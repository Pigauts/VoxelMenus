package me.pigauts.voxelmenus.core.runnable;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class MenusScheduler {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();
    private static final BukkitScheduler scheduler = Bukkit.getScheduler();

    public static BukkitTask runTask(Runnable task) {
        return scheduler.runTask(plugin, task);
    }

    public static BukkitTask runTaskLater(long delay, Runnable task) {
        return scheduler.runTaskLater(plugin, task, delay);
    }

    public static BukkitTask runTaskTimer(long period, Runnable task) {
        return scheduler.runTaskTimer(plugin, task, period, period);
    }

    public static BukkitTask runTaskTimer(long delay, long period, Runnable task) {
        return scheduler.runTaskTimer(plugin, task, delay, period);
    }

    public static BukkitTask runTaskAsync(Runnable task) {
        return scheduler.runTaskAsynchronously(plugin, task);
    }

    public static BukkitTask runTaskLaterAsync(long delay, Runnable task) {
        return scheduler.runTaskLaterAsynchronously(plugin, task, delay);
    }

    public static BukkitTask runTaskTimerAsync(long period, Runnable task) {
        return scheduler.runTaskTimerAsynchronously(plugin, task, period, period);
    }

    public static BukkitTask runTaskTimerAsync(long delay, long period, Runnable task) {
        return scheduler.runTaskTimerAsynchronously(plugin, task, delay, period);
    }

}
