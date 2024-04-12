package me.pigauts.voxelmenus.menu;

import org.bukkit.event.inventory.InventoryType;

public class PagedSettings extends MenuSettings {

    private final String entriesId;
    private final int[] entriesSlots;
    private final boolean perPlayerEntries;

    public PagedSettings(InventoryType storage, int size, int refresh, boolean keepOpen, boolean lockBottom, boolean lockEmpty, String entriesId, int[] entriesSlots, boolean perPlayerEntries) {
        super(storage, size, refresh, keepOpen, lockBottom, lockEmpty);
        this.entriesId = entriesId;
        this.entriesSlots = entriesSlots;
        this.perPlayerEntries = perPlayerEntries;
    }

    public String getEntriesId() {
        return entriesId;
    }

    public int[] getEntriesSlots() {
        return entriesSlots;
    }

    public boolean isPerPlayerEntries() {
        return perPlayerEntries;
    }

}
