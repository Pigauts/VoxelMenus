package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuType;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.menu.view.PagedMenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.menu.widget.entries.MenuEntries;

public class PagedMenu extends StaticMenu {

    private final MenuEntries entries = null;
    private final int[] entryView = null;
    private final int viewSize = 0;

    public PagedMenu(String name, MenuSettings settings, MenuMeta meta) {
        super(name, settings, meta);
    }

    @Override
    public MenuType getType() {
        return MenuType.PAGED;
    }

    public MenuMeta getMenuMeta(int page) {
        MenuMeta pageMeta = meta.clone();

        int startIndex = (page - 1) * viewSize;
        int endIndex = Math.min(page * viewSize, entries.size());

        for (int i = startIndex, j = 0; i < endIndex; i++, j++) {
            pageMeta.setEntry(entryView[j], entries.get(i));
        }

        return pageMeta;
    }

    public int getTotalPages() {
        return (entries.size() + viewSize - 1) / viewSize;
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new PagedMenuView(this, player);
    }


}
