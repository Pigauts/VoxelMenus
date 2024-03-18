package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.menu.type.StaticMenu;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class StaticMenuView<M extends StaticMenu, P extends MenuPlayer> extends MetaMenuView<M, P> {

    public StaticMenuView(M menu, P player) {
        super(menu, player, menu.getMeta());
    }

}
