package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.event.MenuClickEvent;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.button.Button;
import me.pigauts.voxelmenus.user.MenuPlayer;
import org.bukkit.inventory.ItemStack;

public interface Menu {

    String getName();

    String getTitle();

    int getSize();

    int getRefresh();

    Function getOpenFunction();

    Function getCloseFunction();

    Button[] getButtons(MenuPlayer player);

    default Button[] getButtonsByName(MenuPlayer player, String name) {
        return getButtons(player);
    }

    default void onClick(MenuClickEvent event) { }

}
