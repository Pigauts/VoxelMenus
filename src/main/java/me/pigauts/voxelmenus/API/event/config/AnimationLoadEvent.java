package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.animation.Animation;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import org.bukkit.event.HandlerList;

public class AnimationLoadEvent extends ConfigFactoryEvent<Animation> {

    private final static HandlerList HANDLERS = new HandlerList();

    public AnimationLoadEvent(Config config, ConfigFactory<Animation> factory) {
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
