package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.event.menu.MenuUpdateEvent;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.scheduler.BukkitRunnable;

public class MenuUpdateTask extends BukkitRunnable {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    private final MenuPlayer player;
    private final MenuView view;

    private MenuUpdateTask(MenuView view) {
        this.view = view;
        this.player = view.getPlayer();
    }

    @Override
    public void run() {
        if (player.getOpenView() != view) {
            cancel();
            return;
        }

        MenuUpdateEvent event = new MenuUpdateEvent(view);
        VoxelPlugin.callEvent(event);
        view.getMenu().onUpdate(event);

        if (event.isCancelled()) return;

        view.onUpdate();
    }

    public void initiateTask() {
        int refresh = view.getMenu().getRefresh();
        runTaskTimer(plugin, refresh, refresh);
    }

    public static MenuUpdateTask of(MenuView view) {
        if (view == null) return null;
        return new MenuUpdateTask(view);
    }

}
