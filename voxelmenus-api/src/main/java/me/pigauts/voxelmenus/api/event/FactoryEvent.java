package me.pigauts.voxelmenus.api.event;

import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public abstract class FactoryEvent<T> extends Event {

    private T result;

    public FactoryEvent(T result) {
        this.result = result;
    }

    @Nullable
    public T getResult() {
        return result;
    }

    public void setResult(@Nullable T result) {
        this.result = result;
    }

}
