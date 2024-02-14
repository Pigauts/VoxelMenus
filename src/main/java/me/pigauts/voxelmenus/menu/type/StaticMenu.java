package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.menu.view.StaticMenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class StaticMenu extends SimpleMenu {

    protected final MenuMeta meta;

    public StaticMenu(String name, MenuSettings settings, MenuMeta meta) {
        super(name, settings);
        this.meta = meta;
    }

    public MenuMeta getMeta() {
        return meta;
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new StaticMenuView(this, player);
    }

}
