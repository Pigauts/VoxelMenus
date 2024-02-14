package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.type.PageMenu;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class PageMenuView extends MetaMenuView<PageMenu, MenuPlayer> {

    private int currentPage = 0;

    public PageMenuView(PageMenu menu, MenuPlayer player) {
        super(menu, player);
    }

    @Override
    public MenuMeta getMenuMeta() {
        return menu.getMeta(currentPage);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void nextPage() {
        if (currentPage >= menu.getPages()) return;
        this.currentPage++;
        onUpdate();
    }

    public void previousPage() {
        if (currentPage <= 0) return;
        this.currentPage--;
        onUpdate();
    }

}
