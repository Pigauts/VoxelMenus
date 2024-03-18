package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.event.FactoryEvent;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import me.pigauts.voxelmenus.core.holder.ConfigKeyHolder;
import org.bukkit.event.HandlerList;

public class ConditionLoadEvent extends FactoryEvent<Condition> {

    private final static HandlerList HANDLERS = new HandlerList();

    private final ConfigKeyHolder keyHolder;

    public ConditionLoadEvent(ConfigKeyHolder keyHolder, Condition def) {
        super(def);
        this.keyHolder = keyHolder;
    }

    public ConfigKeyHolder getKeyHolder() {
        return keyHolder;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
