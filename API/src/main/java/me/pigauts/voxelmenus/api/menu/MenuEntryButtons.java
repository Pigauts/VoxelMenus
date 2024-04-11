package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.api.menu.button.TemplateEntryButton;

import java.util.ArrayList;

public abstract class MenuEntryButtons extends ArrayList<TemplateEntryButton> {

    private final boolean persistent;

    public MenuEntryButtons(boolean persistent) {
        this.persistent = persistent;
    }

    public boolean isPersistent() {
        return persistent;
    }

}
