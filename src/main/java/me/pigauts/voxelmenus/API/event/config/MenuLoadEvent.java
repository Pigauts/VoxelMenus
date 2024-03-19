package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
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
