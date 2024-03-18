package me.pigauts.voxelmenus.API.event.menu;

import me.pigauts.voxelmenus.API.menu.MenuView;
import org.bukkit.event.HandlerList;

public class MenuCloseEvent extends MenuEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public MenuCloseEvent(MenuView view) {
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
