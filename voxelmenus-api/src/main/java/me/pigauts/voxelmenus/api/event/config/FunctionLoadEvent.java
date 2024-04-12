package me.pigauts.voxelmenus.api.event.config;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
import me.pigauts.voxelmenus.api.function.Function;
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
