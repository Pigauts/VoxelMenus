package me.pigauts.voxelmenus.player;

import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.event.menu.MenuCloseEvent;
import me.pigauts.voxelmenus.event.menu.MenuOpenEvent;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.item.ItemBuilder;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.MenuUpdateTask;
import me.pigauts.voxelmenus.menu.view.MenuView;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MenuPlayer {

    protected final UUID playerId;
    private final Set<String> flags = new HashSet<>();
    private MenuView openView = null;
    private final PlayerCache cache = new PlayerCache();

    public MenuPlayer(UUID playerId) {
        this.playerId = playerId;
    }

    public UUID getUniqueId() {
        return playerId;
    }

    public Player asPlayer() {
        return Bukkit.getPlayer(playerId);
    }

    public OfflinePlayer asOfflinePlayer() { return Bukkit.getOfflinePlayer(playerId); }

    public boolean isViewingMenu() {
        return openView != null;
    }

    public MenuView getOpenView() {
        return openView;
    }

    public <T extends MenuView> T getOpenView(Class<T> viewClass) {
        return viewClass.isAssignableFrom(openView.getClass()) ? viewClass.cast(openView) : null;
    }

    public void setOpenView(MenuView view) {
        this.openView = view;
    }

    public Set<String> getFlags() {
        return flags;
    }

    public void setFlag(String flag, boolean bool) {
        if (bool) {
            flags.add(flag);
            return;
        }
        flags.remove(flag);
    }

    public PlayerCache getCache() {
        return cache;
    }

    public void cacheInventory() {
        cache.cachePlayerInventory(getInventory().getContents());
    }

    public void restoreInventory() {
        ItemStack[] contents = cache.getPlayerInventory();
        if (contents == null) return;
        getInventory().setContents(contents);
    }

    public boolean hasFlag(String flag) {
        return flags.contains(flag);
    }

    public boolean hasPermission(String permission) {
        return asPlayer().hasPermission(permission);
    }

    public void sendMessage(String message) {
        asPlayer().sendMessage(message);
    }

    public void openMenu(Menu menu) {
        if (menu == null) return;
        if (isViewingMenu() && openView.getMenu() == menu) return;

        MenuView view = menu.createView(this);

        MenuOpenEvent event = new MenuOpenEvent(view);
        VoxelPlugin.callEvent(event);
        menu.onOpen(event);

        if (event.isCancelled()) return;

        view.open();
        MenuUpdateTask.of(view).initiateTask();
    }

    public void closeMenu() {
        if (!isViewingMenu()) return;

        MenuCloseEvent event = new MenuCloseEvent(openView);
        VoxelPlugin.callEvent(event);
        openView.getMenu().onClose(event);

        if (event.isCancelled()) return;

        openView.close();
    }

    public void clickMenu(InventoryClickEvent clickEvent) {
        if (!isViewingMenu()) return;

        MenuClickEvent event = new MenuClickEvent(openView, clickEvent);
        VoxelPlugin.callEvent(event);
        openView.getMenu().onClick(event);

        if (event.isCancelled()) return;

        openView.onClick(event);
    }

    public InventoryView openInventory(Inventory inventory) {
       return asPlayer().openInventory(inventory);
    }

    public void closeInventory() {
        asPlayer().closeInventory();
    }

    public void openEnderChest() {
        if (isViewingMenu()) openView = null;
        Player player = asPlayer();
        player.openInventory(player.getEnderChest());
    }

    public void setExp(int amount) {
        asPlayer().setExp(amount);
    }

    public void addExp(int amount) {
        Player player = asPlayer();
        player.setExp(player.getExp() + amount);
    }

    public void setFlag(String flag) {
        flags.add(flag);
    }

    public void unsetFlag(String flag) {
        flags.remove(flag);
    }

    public void teleport(Location location) {
        asPlayer().teleport(location);
    }

    public void heal(int amount) {
        Player player = asPlayer();
        player.setHealth(player.getHealth() + amount);
    }

    public World getWorld() {
        return asPlayer().getWorld();
    }

    public Location getLocation() {
        return asPlayer().getLocation();
    }

    public PlayerInventory getInventory() {
        return asPlayer().getInventory();
    }

    public void performCommand(String command) {
        Player player = asPlayer();
        command = command.replace("%player%", player.getName());
        player.performCommand(command);
    }

    public void performCommandAsOp(String command) {
        Player player = asPlayer();
        command = command.replace("%player%", player.getName());
        if (player.isOp()) {
            player.performCommand(command);
            return;
        }
        player.setOp(true);
        player.performCommand(command);
        player.setOp(false);
    }

    public ItemStack getPlayerHead() {
        return ItemBuilder.createPlayerHead(asOfflinePlayer());
    }

    public void executeFunction(Function function) {
        if (function != null) {
            function.run(this);
        }
    }

}
