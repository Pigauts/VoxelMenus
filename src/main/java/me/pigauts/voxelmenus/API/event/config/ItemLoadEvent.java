package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class ItemLoadEvent extends ConfigFactoryEvent<ItemStack> {

    private final static HandlerList HANDLERS = new HandlerList();

    public ItemLoadEvent(Config config, ConfigFactory<ItemStack> factory) {
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
