package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.Menus;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.jetbrains.annotations.NotNull;

public class DynamicMenuView extends MetaMenuView<DynamicMenu, MenuPlayer> {

    public DynamicMenuView(@NotNull DynamicMenu menu, @NotNull MenuPlayer player) {
        super(menu, player, menu.getMenuMeta(player));
    }

    public DynamicMenuView(@NotNull DynamicMenu menu, @NotNull MenuPlayer player, @NotNull MenuMeta meta) {
        super(menu, player, meta);
    }

    @Override
    public void update() {
        meta = menu.getMenuMeta(player);
        inventory = Menus.createInventory(menu, meta);
        super.update();
    }

}
