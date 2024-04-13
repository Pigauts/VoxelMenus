package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import org.jetbrains.annotations.NotNull;

public class DynamicMenuView extends MetaMenuView<DynamicMenu, MenuPlayer> {

    public DynamicMenuView(@NotNull DynamicMenu menu, @NotNull MenuPlayer player) {
        super(menu, player, menu.getInventoryMeta(player));
    }

    public DynamicMenuView(@NotNull DynamicMenu menu, @NotNull MenuPlayer player, @NotNull InventoryMeta meta) {
        super(menu, player, meta);
    }

    @Override
    public void update() {
        setInventoryMeta(menu.getInventoryMeta(viewer));
        super.update();
    }

}
