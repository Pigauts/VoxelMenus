package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.api.event.menu.MenuUpdateEvent;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.core.runnable.MenusRunnable;
import me.pigauts.voxelmenus.util.Util;


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
        Util.callEvent(event);
        view.getMenu().onUpdate(event);

        if (event.isCancelled()) return;

        view.update();
    }

    public void initiateTask() {
        runTaskTimer(view.getMenu().getRefresh());
    }

    public static MenuUpdateTask of(MenuView view) {
        if (view == null) return null;
        return new MenuUpdateTask(view);
    }

}
