package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.core.event.FactoryEvent;
import org.bukkit.event.HandlerList;

public class FunctionLoadEvent extends FactoryEvent<Function> {

    private final static HandlerList HANDLERS = new HandlerList();

    private final Config config;

    public FunctionLoadEvent(Config config, Function def) {
        super(def);
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
