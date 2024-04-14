package me.pigauts.voxelmenus.core.builder.menu;

import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.menu.PagedSettings;
import me.pigauts.voxelmenus.menu.type.PagedMenu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.util.MenuLayout;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class PagedMenuBuilder extends StaticMenuBuilder {

    private String entriesId;
    private Set<Integer> entrySlots = new HashSet<>();
    private boolean perPlayerEntries;
    private Button template;

    public PagedMenuBuilder(@NotNull ConfigSection config) {
        super(config);
        entriesId = config.getRawString("entries.type");
        perPlayerEntries = config.getBoolean("entries.per-player");
        template = config.create(Button::fromConfig, "entries.template");
        MenuLayout layout = config.create(MenuLayout::fromConfig, "layout");
        for (int i = 0; i < size; i++) {
            if (Util.isEqual(layout.get(i), "v", "^")) {
                entrySlots.add(i);
                buttons[i] = template.clone();
            }
        }
    }

    @Override
    public PagedMenu build() {
        return new PagedMenu(name, getSettings(), getInventoryMeta());
    }

    @Override
    public PagedSettings getSettings() {
        return new PagedSettings(storage, size, refresh, keepOpen, lockBottom, lockEmpty, entriesId, Util.toIntArray(entrySlots), perPlayerEntries);
    }

    public PagedMenuBuilder setEntriesId(String entriesId) {
        this.entriesId = entriesId;
        return this;
    }

    public PagedMenuBuilder setEntrySlot(int slot) {
        entrySlots.add(slot);
        return this;
    }

    public PagedMenuBuilder setPerPlayerEntries(boolean perPlayerEntries) {
        this.perPlayerEntries = perPlayerEntries;
        return this;
    }

    public PagedMenuBuilder setTemplate(Button template) {
        this.template = template;
        return this;
    }


}
