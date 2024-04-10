package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.menu.widget.entries.MenuEntries;

public interface PagedView<M extends Menu, P extends MenuPlayer> extends MetaView<M, P> {

    int getTotalPages();

    boolean isFirstPage();

    boolean isLastPage();

    MenuEntries getEntries();

    int getCurrentPage();

    boolean setCurrentPage(int page);

    void nextPage();

    void previousPage();

}
