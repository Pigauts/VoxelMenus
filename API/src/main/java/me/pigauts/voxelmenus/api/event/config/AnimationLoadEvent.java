package me.pigauts.voxelmenus.api.event.config;

import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
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
