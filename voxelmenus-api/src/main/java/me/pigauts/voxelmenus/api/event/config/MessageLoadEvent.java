package me.pigauts.voxelmenus.api.event.config;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
import me.pigauts.voxelmenus.api.message.Message;
import org.bukkit.event.HandlerList;

public class MessageLoadEvent extends ConfigFactoryEvent<Message> {

    private final static HandlerList HANDLERS = new HandlerList();

    public MessageLoadEvent(Config config, ConfigFactory<Message> factory) {
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
