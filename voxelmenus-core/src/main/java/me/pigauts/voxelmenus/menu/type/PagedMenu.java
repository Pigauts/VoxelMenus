package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.menu.MenuEntryButtons;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.PagedSettings;
import me.pigauts.voxelmenus.menu.view.PagedMenuView;

public class PagedMenu extends StaticMenu {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    private final String entriesId;
    private final int[] entrySlots;
    private final boolean perPlayerEntries;

    public PagedMenu(String name, PagedSettings settings, InventoryMeta meta) {
        super(name, settings, meta);
        this.entriesId = settings.getEntriesId();
        this.entrySlots = settings.getEntriesSlots();
        this.perPlayerEntries = settings.isPerPlayerEntries();
    }

    @Override
    public MenuType getType() {
        return MenuType.PAGED;
    }

    public int[] getEntrySlots() {
        return entrySlots;
    }

    public int getEntrySlotSize() {
        return entrySlots.length;
    }

    public InventoryMeta getMenuMeta(int page) {
        InventoryMeta pageMeta = meta.clone();
        pageMeta.setTitle(pageMeta.getTitle().replaceAll("%page%", String.valueOf(page)));
        return pageMeta;
    }

//    public int getTotalPages() {
//        int slots;
//        return (entries.size() + (slots = entrySlots.length) - 1) / slots;
//    }

    @Override
    public <P extends MenuPlayer> MenuView createView(P player) {
        MenuEntryButtons entries = perPlayerEntries ? player.getCache().getCachedEntries(entriesId) : plugin.getEntries(entriesId);
        return new PagedMenuView(this, player, entries);
    }


}
