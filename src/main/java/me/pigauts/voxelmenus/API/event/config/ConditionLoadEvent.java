package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import org.bukkit.event.HandlerList;

public class ConditionLoadEvent extends ConfigFactoryEvent<Condition> {

    private final static HandlerList HANDLERS = new HandlerList();

    public ConditionLoadEvent(Config config, ConfigFactory<Condition> factory) {
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
