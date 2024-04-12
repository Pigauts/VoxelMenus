package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.menu.MenuSettings;

public class PersistentMenu extends StaticMenu {

    public PersistentMenu(String name, MenuSettings settings, InventoryMeta meta) {
        super(name, settings, meta);
    }

    @Override
    public MenuType getType() {
        return MenuType.PERSISTENT;
    }

}
