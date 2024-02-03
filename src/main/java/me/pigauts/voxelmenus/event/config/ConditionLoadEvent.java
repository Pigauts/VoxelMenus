package me.pigauts.voxelmenus.event.config;

import me.pigauts.voxelmenus.function.statement.condition.Condition;
import org.bukkit.event.HandlerList;

public class ConditionLoadEvent extends KeyObjectLoadEvent<Condition> {

    private final static HandlerList HANDLERS = new HandlerList();

    public ConditionLoadEvent(String key, Object value) {
        super(key, value);
    }

    public ConditionLoadEvent(String key, Object value, Condition result) {
        super(key, value, result);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
