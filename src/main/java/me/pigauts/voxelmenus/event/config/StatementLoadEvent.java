package me.pigauts.voxelmenus.event.config;

import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.function.statement.Statement;
import org.bukkit.event.HandlerList;

public class StatementLoadEvent extends SectionObjectLoadEvent<Statement> {

    private final static HandlerList HANDLERS = new HandlerList();

    public StatementLoadEvent(Config section) {
        super(section);
    }

    public StatementLoadEvent(Config section, Statement result) {
        super(section, result);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
