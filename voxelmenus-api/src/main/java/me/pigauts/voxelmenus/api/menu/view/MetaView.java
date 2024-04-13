package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

/**
 * Represents a view of a menu with associated metadata.
 * A MetaView is a type of MenuView that includes methods
 * for managing inventory metadata and updating the view.
 *
 * @param <M> The type of menu associated with this view.
 * @param <P> The type of player associated with this view.
 */
public interface MetaView<M extends Menu, P extends MenuPlayer> extends MenuView<M, P> {

    /**
     * Returns the inventory metadata of this view.
     *
     * @return The inventory metadata of this view.
     */
    InventoryMeta getInventoryMeta();

    /**
     * Sets the inventory metadata for this view.
     *
     * @param inventoryMeta The inventory metadata to set.
     */
    void setInventoryMeta(InventoryMeta inventoryMeta);

    /**
     * Updates the inventory's title and contents based on the current state.
     */
    void update();

}
