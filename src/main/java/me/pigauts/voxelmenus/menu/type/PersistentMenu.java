package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.API.MenuType;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.MenuSettings;

public class PersistentMenu extends StaticMenu {

    public PersistentMenu(String name, MenuSettings settings, MenuMeta meta) {
        super(name, settings, meta);
    }

    @Override
    public MenuType getType() {
        return MenuType.PERSISTENT;
    }

}
