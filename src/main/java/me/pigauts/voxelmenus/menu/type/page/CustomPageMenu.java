package me.pigauts.voxelmenus.menu.type.page;

import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.type.PageMenu;

import java.util.List;

public class CustomPageMenu extends PageMenu {

    private final List<MenuMeta> pages;

    public CustomPageMenu(String name, MenuSettings settings, int[] pageSlots, Icon[] template, List<MenuMeta> pages) {
        super(name, settings, pageSlots, template);
        this.pages = pages;
    }

    @Override
    public int getPages() {
        return pages.size();
    }

    @Override
    public MenuMeta getMeta(int page) {
        MenuMeta layout = pages.get(page);

        for (Icon button : layout.getIcons()) {
//            button.setItemMeta(getTemplate().getItemMeta());
        }

        return layout;
    }

}
