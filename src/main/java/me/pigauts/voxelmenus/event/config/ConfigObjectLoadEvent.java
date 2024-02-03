package me.pigauts.voxelmenus.event.config;

import org.bukkit.event.Event;

public abstract class ConfigObjectLoadEvent<T> extends Event {

    private T result;

    public ConfigObjectLoadEvent(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
