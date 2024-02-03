package me.pigauts.voxelmenus.menu.button;

import me.pigauts.voxelmenus.event.MenuClickEvent;
import org.bukkit.inventory.ItemStack;

public interface Button {

    Button[] EMPTY_BUTTONS = new Button[54];

    ItemStack getItem();

    default void onClick(MenuClickEvent event) { }

}
