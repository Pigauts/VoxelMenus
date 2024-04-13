package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.api.menu.button.TemplateEntryButton;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuEntryButtons extends ArrayList<TemplateEntryButton> {

    public static final MenuEntryButtons EMPTY_ENTRIES = null; //change

    private final boolean persistent;

    public MenuEntryButtons(boolean persistent) {
        this.persistent = persistent;
    }

    public boolean isPersistent() {
        return persistent;
    }

    public List<TemplateEntryButton> get(int startIndex, int endIndex) {
        return subList(startIndex, endIndex);
    }

}
