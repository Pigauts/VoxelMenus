package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.view.StaticMenuView;

public class StaticMenu extends SimpleMenu {

    protected final InventoryMeta inventoryMeta;

    public StaticMenu(String name, MenuSettings settings, InventoryMeta meta) {
        super(name, settings);
        this.inventoryMeta = meta;
    }

    @Override
    public MenuType getType() {
        return MenuType.STATIC;
    }

    public InventoryMeta getInventoryMeta() {
        return inventoryMeta.clone();
    }

    @Override
    public <P extends MenuPlayer> MenuView createView(P player) {
        return new StaticMenuView(this, player);
    }

}
