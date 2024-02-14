package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.menu.view.PageMenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;

public abstract class PageMenu extends SimpleMenu {

    private final int[] pageSlots;
    private final Icon[] template;

    public PageMenu(String name, MenuSettings settings, int[] pageSlots, Icon[] template) {
        super(name, settings);
        this.pageSlots = pageSlots;
        this.template = template;
    }

    public abstract int getPages();

    public abstract MenuMeta getMeta(int page);

    public int[] getPageSlots() {
        return pageSlots;
    }

    public Icon[] getTemplate() {
        return template;
    }

    public Icon getTemplate(int slot) {
        return template[slot];
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new PageMenuView(this, player);
    }

}
