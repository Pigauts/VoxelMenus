package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.util.atlas.Atlas;
import me.pigauts.voxelmenus.util.atlas.InventoryWindow;
import org.bukkit.event.inventory.InventoryType;

public class AtlasSettings extends MenuSettings {

    private final Atlas canvas;
    private final InventoryWindow window;

    public AtlasSettings(InventoryType storage, int size, int refresh, boolean keepOpen, boolean lockBottom, boolean lockEmpty, Atlas canvas, InventoryWindow window) {
        super(storage, size, refresh, keepOpen, lockBottom, lockEmpty);
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
