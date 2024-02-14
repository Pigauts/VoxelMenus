package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.type.StaticMenu;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class StaticMenuView<M extends StaticMenu, P extends MenuPlayer> extends MetaMenuView<M, P> {

    public StaticMenuView(M menu, P player) {
        super(menu, player);
    }

    @Override
    public MenuMeta getMenuMeta() {
        return menu.getMeta();
    }

}
