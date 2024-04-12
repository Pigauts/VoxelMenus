package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import me.pigauts.voxelmenus.api.core.InventoryUtils;
import org.jetbrains.annotations.NotNull;

public class DynamicMenuView extends MetaMenuView<DynamicMenu, MenuPlayer> {

    public DynamicMenuView(@NotNull DynamicMenu menu, @NotNull MenuPlayer player) {
        super(menu, player, menu.getMenuMeta(player));
    }

    public DynamicMenuView(@NotNull DynamicMenu menu, @NotNull MenuPlayer player, @NotNull InventoryMeta meta) {
        super(menu, player, meta);
    }

    @Override
    public void update() {
        meta = menu.getMenuMeta(viewer);
        inventory = InventoryUtils.createInventory(menu, meta);
        super.update();
    }

}
