package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.api.menu.atlas.Atlas;
import me.pigauts.voxelmenus.api.menu.atlas.InventoryWindow;

public class AtlasSettings extends MenuSettings {

    private final Atlas canvas;
    private final InventoryWindow window;

    public AtlasSettings(int refresh, boolean keepOpen, boolean lockBottom, boolean lockEmpty, Atlas canvas, InventoryWindow window) {
        super(refresh, keepOpen, lockBottom, lockEmpty);
        this.canvas = canvas;
        this.window = window;
    }

    public Atlas getCanvas() {
        return canvas;
    }

    public InventoryWindow getWindow() {
        return window;
    }

}
