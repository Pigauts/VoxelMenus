package me.pigauts.voxelmenus.event.menu;

import me.pigauts.voxelmenus.event.CancellableEvent;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;

public abstract class MenuViewEvent extends CancellableEvent {

    private final MenuView view;

    public MenuViewEvent(MenuView view) {
        this.view = view;
    }

    public MenuPlayer getPlayer() {
        return view.getPlayer();
    }

    public MenuView getView() {
        return view;
    }

}
