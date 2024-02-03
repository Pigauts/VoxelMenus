package me.pigauts.voxelmenus.event.config;

import me.pigauts.voxelmenus.function.statement.action.Action;
import org.bukkit.event.HandlerList;

public class ActionLoadEvent extends KeyObjectLoadEvent<Action> {

    private final static HandlerList HANDLERS = new HandlerList();

    public ActionLoadEvent(String key, Object value) {
        super(key, value);
    }

    public ActionLoadEvent(String key, Object value, Action result) {
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
