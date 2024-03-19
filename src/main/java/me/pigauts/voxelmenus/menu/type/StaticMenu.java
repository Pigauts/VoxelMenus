package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.API.MenuType;
import me.pigauts.voxelmenus.core.builder.StaticMenuBuilder;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.menu.view.StaticMenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class StaticMenu extends SimpleMenu {

    protected final MenuMeta meta;

    public StaticMenu(String name, MenuSettings settings, MenuMeta meta) {
        super(name, settings);
        this.meta = meta;
    }

    public static StaticMenu fromConfig(ConfigSection config) {
        if (config == null) return null;
        return new StaticMenuBuilder(config).build();
    }

    @Override
    public MenuType getType() {
        return MenuType.STATIC;
    }

    public MenuMeta getMenuMeta() {
        return meta;
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new StaticMenuView(this, player);
    }

}
