package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.api.event.menu.MenuCloseEvent;
import me.pigauts.voxelmenus.api.event.menu.MenuOpenEvent;
import me.pigauts.voxelmenus.api.event.menu.MenuUpdateEvent;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

public interface Menu {

    /**
     * Gets the type of the menu.
     *
     * @return The type of the menu.
     */
    @NotNull
    MenuType getType();

    /**
     * Gets the name of the menu.
     *
     * @return The name of the menu.
     */
    @NotNull
    String getName();

    /**
     * Gets the storage type of the menu.
     *
     * @return The storage type of the menu.
     */
    @NotNull
    InventoryType getStorage();

    /**
     * Gets the size of the menu.
     *
     * @return The size of the menu.
     */
    int getSize();

    /**
     * Gets the refresh rate of the menu.
     *
     * @return The refresh rate of the menu.
     */
    int getRefresh();

    /**
     * Checks if the menu should remain open after pressing escape.
     *
     * @return True if the menu should remain open, otherwise false.
     */
    boolean keepOpen();

    /**
     * Checks if the bottom row of the menu should be locked.
     *
     * @return True if the bottom row should be locked, otherwise false.
     */
    boolean lockBottom();

    /**
     * Checks if the menu should lock empty slots.
     *
     * @return True if empty slots should be locked, otherwise false.
     */
    boolean lockEmpty();

    /**
     * Creates a new view of the menu for the specified player.
     *
     * @param player The player to create the view for.
     * @return The created menu view.
     */
    @NotNull
    <P extends MenuPlayer> MenuView createView(@NotNull P player);


    /**
     * Called when a view of this menu is opened.
     *
     * @param event The event associated with opening the view
     */
    default void onOpen(@NotNull MenuOpenEvent event) {}

    /**
     * Called when a view of this menu is closed.
     *
     * @param event The event associated with closing the view
     */
    default void onClose(@NotNull MenuCloseEvent event) {}

    /**
     * Called when a view of this menu is updated.
     *
     * @param event The event associated with updating the view
     */
    default void onUpdate(@NotNull MenuUpdateEvent event) {}

    /**
     * Called when a view of this menu is clicked.
     *
     * @param event The event associated with clicking the view
     */
    default void onClick(@NotNull MenuClickEvent event) {}

}
