package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public interface MetaView<M extends Menu, P extends MenuPlayer> extends MenuView<M, P> {

    InventoryMeta getMenuMeta();

    void setMenuMeta(InventoryMeta meta);

}
