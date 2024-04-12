package me.pigauts.voxelmenus.menu;

import org.bukkit.event.inventory.InventoryType;

public class MenuSettings {

    private final InventoryType storage;
    private final int size;
    private final int refresh;
    private final boolean keepOpen;
    private final boolean lockBottom;
    private final boolean lockEmpty;

    public MenuSettings(InventoryType storage, int size, int refresh, boolean keepOpen, boolean lockBottom, boolean lockEmpty) {
        this.storage = storage;
        this.size = size;
        this.refresh = refresh;
        this.keepOpen = keepOpen;
        this.lockBottom = lockBottom;
        this.lockEmpty = lockEmpty;
    }

    public InventoryType getStorage() {
        return storage;
    }

    public int getSize() {
        return size;
    }

    public int getRefresh() {
        return refresh;
    }

    public boolean isKeepOpen() {
        return keepOpen;
    }

    public boolean isLockBottom() {
        return lockBottom;
    }

    public boolean isLockEmpty() {
        return lockEmpty;
    }

}
