package me.pigauts.voxelmenus.api.event.menu;

import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.event.HandlerList;

public class MenuUpdateEvent extends MenuEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    public MenuUpdateEvent(MenuView view) {
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