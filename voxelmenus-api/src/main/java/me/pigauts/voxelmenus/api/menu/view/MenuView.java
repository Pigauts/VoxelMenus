package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.button.ViewButton;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Represents a view of a menu displayed to a player.
 *
 * @param <M> The type of menu associated with this view.
 * @param <P> The type of player associated with this view.
 */
public interface MenuView<M extends Menu, P extends MenuPlayer> {

    /**
     * Retrieves the previous MenuView in the sequence, if available.
     *
     * @return The previous MenuView, or {@code null} if there is no previous view.
     */
    @Nullable
    MenuView getPreviousView();

    /**
     * Sets the previous MenuView in the sequence.
     *
     * @param previousView The MenuView to set as the previous view.
     */
    void setPreviousView(MenuView previousView);

    /**
     * Gets the menu associated with this view.
     *
     * @return The menu object.
     */
    @NotNull
    M getMenu();

    /**
     * Gets the player associated with this view.
     *
     * @return The player object.
     */
    @NotNull
    P getViewer();

    /**
     * Gets the top inventory of the view.
     *
     * @return The top inventory.
     */
    Inventory getInventory();

    ViewButton[] getButtons();

    boolean isClosed();

    /**
     * Gets a list of animations currently playing in the menu view.
     *
     * @return The list of animations.
     */
    @NotNull
    List<Animation> getPlayingAnimations();

    /**
     * Opens the menu view.
     */
    void open();

    /**
     * Closes the menu view.
     */
    void close();

    /**
     * Updates the inventory contents
     */
    void refresh();

    /**
     * Opens the previous menu view if existent.
     */
    void back();

    /**
     * Handler for inventory clicks.
     */
    void click(InventoryClickEvent event);

}
