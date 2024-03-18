package me.pigauts.voxelmenus.API.menu.view;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.Menu;

public interface PagedView<M extends Menu, P extends MenuPlayer> extends MetaView<M, P> {

    int getCurrentPage();

    void setPage(int page);

    void nextPage();

    void previousPage();

}
