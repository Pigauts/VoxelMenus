package me.pigauts.voxelmenus.API.event.menu;

import me.pigauts.voxelmenus.core.event.CancellableEvent;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;

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
