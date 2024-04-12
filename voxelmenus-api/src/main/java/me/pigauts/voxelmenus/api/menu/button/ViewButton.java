package me.pigauts.voxelmenus.api.menu.button;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a button within a menu view.
 */
public interface ViewButton {

    /**
     * Creates the item stack representation of the button.
     *
     * @return The ItemStack representing the button.
     */
    ItemStack createViewItem();

    /**
     * Handles the click event on the button.
     *
     * @param event The InventoryClickEvent of the current view
     */
    void click(InventoryClickEvent event);

}
