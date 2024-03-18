package me.pigauts.voxelmenus.API.event.config;

import me.pigauts.voxelmenus.core.event.FactoryEvent;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.holder.ConfigKeyHolder;
import org.bukkit.event.HandlerList;

public class ActionLoadEvent extends FactoryEvent<Action> {

    private final static HandlerList HANDLERS = new HandlerList();

    private final ConfigKeyHolder keyHolder;

    public ActionLoadEvent(ConfigKeyHolder keyHolder, Action def) {
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
