package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.core.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import org.bukkit.event.HandlerList;

public class FunctionLoadEvent extends ConfigFactoryEvent<Function> {

    private final static HandlerList HANDLERS = new HandlerList();

    public FunctionLoadEvent(Config config, ConfigFactory<Function> factory) {
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
