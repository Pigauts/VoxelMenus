package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.menu.widget.Entry;

import java.util.ArrayList;

public abstract class MenuEntries extends ArrayList<Entry> {

    private final boolean persistent;

    public MenuEntries(boolean persistent) {
        this.persistent = persistent;
    }

    public boolean isPersistent() {
        return persistent;
    }

}
