package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.API.event.menu.MenuUpdateEvent;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.runnable.MenusRunnable;


public class MenuUpdateTask extends MenusRunnable {

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
        runTaskTimer(view.getMenu().getRefresh());
    }

    public static MenuUpdateTask of(MenuView view) {
        if (view == null) return null;
        return new MenuUpdateTask(view);
    }

}
