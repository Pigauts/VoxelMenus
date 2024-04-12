package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.core.enums.MenuFunction;
import me.pigauts.voxelmenus.api.menu.MenuEntryButtons;
import me.pigauts.voxelmenus.api.menu.view.PagedView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.type.PagedMenu;
import me.pigauts.voxelmenus.util.Utils;

public class PagedMenuView<M extends PagedMenu, P extends MenuPlayer> extends MetaMenuView<M, P> implements PagedView<M, P> {

    private final MenuEntryButtons entries;
    private int currentPage;

    public PagedMenuView(M menu, P player, MenuEntryButtons entries) {
        this(menu, player, entries, 0);
    }

    public PagedMenuView(M menu, P player, MenuEntryButtons entries, int startingPage) {
        super(menu, player, menu.getMenuMeta(startingPage));
        this.entries = Utils.nonNullOrElse(entries, MenuEntryButtons.EMPTY_ENTRIES);
        this.currentPage = startingPage;
    }

    @Override
    public void update() {
        meta = menu.getMenuMeta().clone();

        meta.setTitle(meta.getTitle().replaceAll("%page%", String.valueOf(currentPage + 1)));

        int startIndex = (currentPage - 1) * menu.getEntrySlotSize();
        int endIndex = Math.min(currentPage * menu.getEntrySlotSize(), entries.size());

        for (int i = startIndex, j = 0; i < endIndex; i++, j++) {
//            meta.setEntry(menu.getEntrySlots()[j], entries.get(i));
        }

        super.update();
    }

    @Override
    public int getTotalPages() {
        int slots;
        return (entries.size() + (slots = menu.getEntrySlotSize()) - 1) / slots;
    }

    @Override
    public boolean isFirstPage() {
        return currentPage == 0;
    }

    @Override
    public boolean isLastPage() {
        return currentPage == getTotalPages() - 1;
    }

    @Override
    public MenuEntryButtons getEntries() {
        return entries;
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public boolean setCurrentPage(int page) {
        if (page < 0 || page >= getTotalPages()) return false;
        this.currentPage = page;
        update();
        return true;
    }

    @Override
    public void nextPage() {
        if (setCurrentPage(currentPage + 1)) {
            viewer.runFunction(meta.getFunction(MenuFunction.PAGE_TURN));
        }
    }

    @Override
    public void previousPage() {
        if (setCurrentPage(currentPage - 1)) {
            viewer.runFunction(meta.getFunction(MenuFunction.PAGE_TURN));
        }
    }

}
