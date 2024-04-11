package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

/**
 * A button template for view buttons
 */
public interface TemplateButton {

    /**
     * Creates a new ViewButton associated with the given MenuView.
     *
     * @param view The MenuView to associate with the ViewButton.
     * @return A new ViewButton associated with the given MenuView.
     */
    ViewButton createViewButton(MenuView view);

    /**
     * Retrieves the item stack representing the button.
     *
     * @return The ItemStack representing the button.
     */
    ItemStack getButtonItem();

    /**
     * Retrieves the function associated with the specified click type.
     *
     * @param click The ClickType for which to retrieve the function.
     * @return The function associated with the specified click type.
     */
    Function getFunction(ClickType click);

    /**
     * Adds a function associated with the specified click type to the button.
     *
     * @param click    The ClickType for which to add the function.
     * @param function The function to be added.
     * @return The modified TemplateButton.
     */
    TemplateButton addFunction(ClickType click, Function function);

    /**
     * Checks if the button is locked.
     *
     * @return True if the button is locked, otherwise false.
     */
    boolean isLocked();

    /**
     * Sets the locked status of the button.
     *
     * @param locked True to lock the button, false to unlock it.
     */
    void setLocked(boolean locked);

    /**
     * Retrieves all functions associated with the button.
     *
     * @return A map containing all functions associated with the button.
     */
    Map<ClickType, Function> getFunctions();

    /**
     * Retrieves the cooldown period for the button.
     *
     * @return The cooldown period for the button.
     */
    int getCooldown();

    /**
     * Sets the cooldown period for the button.
     *
     * @param cooldown The cooldown period to set.
     */
    void setCooldown(int cooldown);

    /**
     * Removes the function associated with the specified click type from the button.
     *
     * @param click The ClickType for which to remove the function.
     * @return True if the function was removed, otherwise false.
     */
    void removeFunction(ClickType click);

    /**
     * Clears all functions associated with the button.
     */
    void clearFunctions();

    /**
     * Checks if the button has a function associated with the specified click type.
     *
     * @param click The ClickType to check for.
     * @return True if a function is associated with the specified click type, otherwise false.
     */
    boolean hasFunction(ClickType click);

}
