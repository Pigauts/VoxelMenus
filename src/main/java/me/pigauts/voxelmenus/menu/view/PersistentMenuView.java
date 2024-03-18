package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.Menu;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class PersistentMenuView extends SimpleView {


    public PersistentMenuView(@NotNull Menu menu, @NotNull MenuPlayer player) {
        super(menu, player);
    }

    public PersistentMenuView(@NotNull Menu menu, @NotNull MenuPlayer player, @NotNull Inventory inventory) {
        super(menu, player, inventory);
    }


}
