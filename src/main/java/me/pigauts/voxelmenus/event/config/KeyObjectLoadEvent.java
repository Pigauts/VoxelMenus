package me.pigauts.voxelmenus.event.config;

import me.pigauts.voxelmenus.Helper;

public abstract class KeyObjectLoadEvent<T> extends ConfigObjectLoadEvent<T> {

    private final String key;
    private final Object value;

    public KeyObjectLoadEvent(String key, Object value) {
        this(key, value, null);
    }

    public KeyObjectLoadEvent(String key, Object value, T result) {
        super(result);
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public <T> T getValue(Class<T> clazz) {
        return Helper.cast(value, clazz);
    }

}
