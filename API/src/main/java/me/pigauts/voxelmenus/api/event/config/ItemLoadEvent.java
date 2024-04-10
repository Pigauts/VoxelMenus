package me.pigauts.voxelmenus.api.event.config;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.ConfigFactoryEvent;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
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
