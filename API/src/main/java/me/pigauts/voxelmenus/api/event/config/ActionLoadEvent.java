package me.pigauts.voxelmenus.api.event.config;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
import me.pigauts.voxelmenus.api.function.Action;
import org.bukkit.event.HandlerList;

public class ActionLoadEvent extends ConfigFactoryEvent<Action> {

    private final static HandlerList HANDLERS = new HandlerList();

    public ActionLoadEvent(Config config, ConfigFactory<Action> factory) {
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
