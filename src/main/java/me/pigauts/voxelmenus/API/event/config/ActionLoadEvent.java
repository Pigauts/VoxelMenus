package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.function.action.Action;
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
