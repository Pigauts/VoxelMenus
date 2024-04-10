package me.pigauts.voxelmenus.api.player;

import me.pigauts.voxelmenus.api.flag.Flag;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.message.Title;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface MenuPlayer {

    /**
     * Gets the unique identifier of the player.
     *
     * @return The unique identifier of the player.
     */
    UUID getUniqueId();

    /**
     * Converts the player to a Bukkit Player object.
     *
     * @return The Bukkit Player object.
     */
    Player asPlayer();

    /**
     * Converts the player to an offline player.
     *
     * @return The offline player representation.
     */
    OfflinePlayer asOfflinePlayer();

    /**
     * Checks if the player is currently viewing a menu.
     *
     * @return True if the player is viewing a menu, otherwise false.
     */
    boolean isViewingMenu();

    /**
     * Gets the currently open menu view for the player.
     *
     * @return The open menu view, or null if the player is not viewing any menu.
     */
    MenuView getOpenView();

    /**
     * Gets the currently open menu view for the player, cast to a specific type.
     *
     * @param viewClass The class of the menu view to retrieve.
     * @param <T>       The type of the menu view.
     * @return The open menu view cast to the specified type, or null if not found.
     */
    <T extends MenuView> Optional<T> getOpenView(Class<T> viewClass);

    /**
     * Sets the currently open menu view for the player.
     *
     * @param view The menu view to set as open.
     */
    void setOpenView(MenuView view);

    /**
     * Opens the specified MenuView.
     *
     * @param view The MenuView to open.
     */
    void openView(MenuView view);

    /**
     * Closes the currently open view.
     */
    void closeView();

    /**
     * Gets the list of flags associated with the player.
     *
     * @return The list of flags.
     */
    Collection<String> getFlags();


    /**
     * Adds a flag to the player's set of flags.
     *
     * @param flag The flag to add.
     */
    void addFlag(Flag flag);

    /**
     * Removes a flag from the player's set of flags.
     *
     * @param flag The flag to remove.
     */
    void removeFlag(Flag flag);

    /**
     * Removes a flag from the player's set of flags.
     *
     * @param name The name of the flag to remove.
     */
    void removeFlag(String name);

    /**
     * Checks if the player has a specific flag.
     *
     * @param name The name of the flag to check.
     * @return True if the player has the flag, otherwise false.
     */
    boolean hasFlag(String name);

    /**
     * Checks if the player has a specific flag.
     *
     * @param flag The flag to check.
     * @return True if the player has the flag, otherwise false.
     */
    boolean hasFlag(Flag flag);

    /**
     * Checks if the player has a specific permission.
     *
     * @param permission The permission to check.
     * @return True if the player has the permission, otherwise false.
     */
    boolean hasPermission(String permission);

    /**
     * Sends a message to the player.
     *
     * @param message The message to send.
     */
    void sendMessage(String message);

    /**
     * Sends a title to the player.
     *
     * @param title The title to send.
     */
    void sendTitle(Title title);

    /**
     * Opens a menu for the player.
     *
     * @param menu The menu to open.
     */
    void openMenu(Menu menu);

    /**
     * Simulates a click event on the player's menu.
     *
     * @param clickEvent The inventory click event to simulate.
     */
    void clickMenu(InventoryClickEvent clickEvent);

    /**
     * Opens an inventory for the player.
     *
     * @param inventory The inventory to open.
     * @return The inventory view.
     */
    InventoryView openInventory(Inventory inventory);

    /**
     * Closes the currently open inventory for the player.
     */
    void closeInventory();

    /**
     * Opens the player's ender chest inventory.
     */
    void openEnderChest();

    /**
     * Sets the experience level of the player.
     *
     * @param amount The amount of experience levels to set.
     */
    void setExp(int amount);

    /**
     * Adds experience levels to the player's current experience.
     *
     * @param amount The amount of experience levels to add.
     */
    void addExp(int amount);

    /**
     * Removes experience levels from the player's current experience.
     *
     * @param amount The amount of experience levels to remove.
     */
    void removeExp(int amount);

    /**
     * Teleports the player to a specific location.
     *
     * @param location The location to teleport the player to.
     */
    void teleport(Location location);

    /**
     * Heals the player by a specified amount.
     *
     * @param amount The amount to heal the player.
     */
    void heal(int amount);

    /**
     * Damages the player by a specified amount.
     *
     * @param amount The amount to damage the player.
     */
    void damage(int amount);

    /**
     * Gets the world the player is currently in.
     *
     * @return The world the player is in.
     */
    World getWorld();

    /**
     * Gets the location of the player.
     *
     * @return The location of the player.
     */
    Location getLocation();

    /**
     * Gets the player's inventory.
     *
     * @return The player's inventory.
     */
    PlayerInventory getInventory();

    /**
     * Executes a command as the player.
     *
     * @param command The command to execute.
     */
    void performCommand(String command);

    /**
     * Executes a command as an operator (op) on the server.
     *
     * @param command The command to execute as an operator.
     */
    void performCommandAsOp(String command);

    /**
     * Gets a player head item representing the player.
     *
     * @return The player head item.
     */
    ItemStack getPlayerHead();

    /**
     * Executes a custom function for the player.
     *
     * @param function The function to execute.
     */
    void runFunction(Function function);

    /**
     * Gives the player one or more items.
     *
     * @param items The items to give to the player.
     */
    void giveItem(ItemStack... items);

    /**
     * Gets the cache associated with the player.
     *
     * @return The cache object.
     */
    PlayerCache getCache();

    /**
     * Caches the player's current inventory contents.
     * This is typically used before opening a menu to ensure the player's original inventory state can be restored later.
     */
    void cacheInventory();

    /**
     * Restores the player's inventory to its cached state.
     * This is typically used after closing a menu to revert the player's inventory to its original state.
     */
    void restoreInventory();

    void updateInventory();

}
