package me.pigauts.voxelmenus.event.config;

import me.pigauts.voxelmenus.config.Config;

public abstract class SectionObjectLoadEvent<T> extends ConfigObjectLoadEvent<T> {

    private final Config section;

    public SectionObjectLoadEvent(Config section) {
        this(section, null);
    }

    public SectionObjectLoadEvent(Config section, T result) {
        super(result);
        this.section = section;
    }

    public Config getSection() {
        return section;
    }

}
