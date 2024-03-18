package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.MenuAction;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.view.PagedView;
import me.pigauts.voxelmenus.menu.type.PagedMenu;

public class PagedMenuView<M extends PagedMenu, P extends MenuPlayer> extends MetaMenuView<M, P> implements PagedView<M, P> {

    private int currentPage;

    public PagedMenuView(M menu, P player) {
        this(menu, player, 0);
    }

    public PagedMenuView(M menu, P player, int startingPage) {
        super(menu, player, menu.getMenuMeta(startingPage));
        this.currentPage = startingPage;
    }

    @Override
    public void update() {
        super.setMenuMeta(menu.getMenuMeta(currentPage));
        super.update();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setPage(int page) {
        if (page < 0 || page > menu.getTotalPages()) return;
        this.currentPage = page;
        update();
    }

    public void nextPage() {
        setPage(currentPage + 1);
        player.executeFunction(meta.getFunction(MenuAction.PAGE_TURN));
    }

    public void previousPage() {
        setPage(currentPage - 1);
        player.executeFunction(meta.getFunction(MenuAction.PAGE_TURN));
    }

}
