package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class DynamicMenuView extends MetaMenuView<DynamicMenu, MenuPlayer> {

    public DynamicMenuView(DynamicMenu menu, MenuPlayer player) {
        super(menu, player);
    }

    @Override
    public MenuMeta getMenuMeta() {
        return menu.getMeta(player);
    }

}
