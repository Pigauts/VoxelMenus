package me.pigauts.voxelmenus.api.event.menu;

import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.event.HandlerList;

public class MenuOpenEvent extends MenuEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public MenuOpenEvent(MenuView view) {
        super(view);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
