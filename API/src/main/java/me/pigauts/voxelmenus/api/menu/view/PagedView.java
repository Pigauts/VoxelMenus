package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.MenuEntryButtons;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public interface PagedView<M extends Menu, P extends MenuPlayer> extends MetaView<M, P> {

    int getTotalPages();

    boolean isFirstPage();

    boolean isLastPage();

    MenuEntryButtons getEntries();

    int getCurrentPage();

    boolean setCurrentPage(int page);

    void nextPage();

    void previousPage();

}
