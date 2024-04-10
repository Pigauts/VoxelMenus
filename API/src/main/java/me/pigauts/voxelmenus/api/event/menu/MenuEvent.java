package me.pigauts.voxelmenus.api.event.menu;

import me.pigauts.voxelmenus.api.event.CancellableEvent;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public abstract class MenuEvent extends CancellableEvent {

    private final MenuView view;

    public MenuEvent(MenuView view) {
        this.view = view;
    }

    public MenuPlayer getPlayer() {
        return view.getPlayer();
    }

    public MenuView getView() {
        return view;
    }

}
