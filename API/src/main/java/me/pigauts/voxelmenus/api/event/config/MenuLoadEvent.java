package me.pigauts.voxelmenus.api.event.config;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
import me.pigauts.voxelmenus.api.menu.Menu;
import org.bukkit.event.HandlerList;

public class MenuLoadEvent extends ConfigFactoryEvent<Menu> {

    private final static HandlerList HANDLERS = new HandlerList();

    public MenuLoadEvent(Config config, ConfigFactory<Menu> factory) {
        super(config, factory);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
