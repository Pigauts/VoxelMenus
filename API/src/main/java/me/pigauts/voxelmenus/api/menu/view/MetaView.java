package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.menu.MenuMeta;

public interface MetaView<M extends Menu, P extends MenuPlayer> extends MenuView<M, P> {

    MenuMeta getMenuMeta();

    void setMenuMeta(MenuMeta meta);

}
