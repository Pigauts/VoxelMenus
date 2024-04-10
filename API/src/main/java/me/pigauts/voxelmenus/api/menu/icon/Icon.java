package me.pigauts.voxelmenus.api.menu.icon;

import me.pigauts.voxelmenus.api.event.menu.MenuClickEvent;
import org.bukkit.inventory.ItemStack;

public interface Icon {

    ItemStack createItem();

    void click(MenuClickEvent event);

}
