package me.pigauts.voxelmenus.player;

import me.pigauts.voxelmenus.api.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.api.event.menu.MenuCloseEvent;
import me.pigauts.voxelmenus.api.event.menu.MenuOpenEvent;
import me.pigauts.voxelmenus.api.flag.Flag;
import me.pigauts.voxelmenus.api.flag.FlagMap;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.message.Title;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.api.player.PlayerCache;
import me.pigauts.voxelmenus.item.ItemBuilder;
import me.pigauts.voxelmenus.menu.MenuUpdateTask;
import me.pigauts.voxelmenus.util.Util;
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

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class VoxelMenuPlayer implements MenuPlayer {

    protected final UUID playerId;
    private final FlagMap flags = null;
    private MenuView openView = null;
    private final PlayerCache cache = new PlayerCache();

    public VoxelMenuPlayer(UUID playerId) {
        this.playerId = playerId;
    }

    @Override
    public UUID getUniqueId() {
        return playerId;
    }

    @Override
    public Player asPlayer() {
        return Bukkit.getPlayer(playerId);
    }

    @Override
    public OfflinePlayer asOfflinePlayer() { return Bukkit.getOfflinePlayer(playerId); }

    @Override
    public boolean isViewingMenu() {
        return openView != null;
    }

    @Override
    public MenuView getOpenView() {
        return openView;
    }

    @Override
    public <T extends MenuView> Optional<T> getOpenView(Class<T> viewClass) {
        return Optional.ofNullable(viewClass.isAssignableFrom(openView.getClass()) ? viewClass.cast(openView) : null);
    }

    @Override
    public void setOpenView(MenuView view) {
        this.openView = view;
    }

    @Override
    public void openView(MenuView view) {
        if (view == null) return;
        view.open();
    }

    @Override
    public Collection<String> getFlags() {
        return flags.names();
    }

    @Override
    public void addFlag(Flag flag) {
        flags.addFlag(flag);
    }

    @Override
    public void removeFlag(Flag flag) {
        flags.removeFlag(flag);
    }

    @Override
    public void removeFlag(String name) {
        flags.removeFlag(name);
    }

    @Override
    public PlayerCache getCache() {
        return cache;
    }

    @Override
    public void cacheInventory() {
        cache.cachePlayerInventory(getInventory().getContents());
    }

    @Override
    public void restoreInventory() {
        ItemStack[] contents = cache.getPlayerInventory();
        if (contents == null) return;
        getInventory().setContents(contents);
    }

    @Override
    public void updateInventory() {
        asPlayer().updateInventory();
    }

    @Override
    public boolean hasFlag(String name) {
        return flags.contains(name);
    }

    @Override
    public boolean hasFlag(Flag flag) {
        return flags.contains(flag);
    }

    @Override
    public boolean hasPermission(String permission) {
        return asPlayer().hasPermission(permission);
    }

    @Override
    public void sendMessage(String message) {
        asPlayer().sendMessage(message);
    }

    @Override
    public void sendTitle(Title title) {
        asPlayer().sendTitle(title.title(), title.subtitle(), title.fadeIn(), title.stay(), title.fadeOut());
    }

    @Override
    public void openMenu(Menu menu) {
        if (menu == null) {
            System.out.println("Menu is null");
            return;
        }
        if (isViewingMenu() && openView.getMenu() == menu) return;

        MenuView view = menu.createView(this);

        MenuOpenEvent event = new MenuOpenEvent(view);
        Util.callEvent(event);
        menu.onOpen(event);

        if (event.isCancelled()) return;

        view.open();
        MenuUpdateTask.of(view).initiateTask();
    }

    @Override
    public void closeView() {
        if (!isViewingMenu()) return;

        MenuCloseEvent event = new MenuCloseEvent(openView);
        Util.callEvent(event);
        openView.getMenu().onClose(event);

        if (event.isCancelled()) return;

        openView.close();
    }

    @Override
    public void clickMenu(InventoryClickEvent clickEvent) {
        if (!isViewingMenu()) return;

        MenuClickEvent event = new MenuClickEvent(openView, clickEvent);
        Util.callEvent(event);
        openView.getMenu().onClick(event);

        if (event.isCancelled()) return;

        openView.click(clickEvent);
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        return asPlayer().openInventory(inventory);
    }

    @Override
    public void closeInventory() {
        asPlayer().closeInventory();
    }

    @Override
    public void openEnderChest() {
        if (isViewingMenu()) openView = null;
        Player player = asPlayer();
        player.openInventory(player.getEnderChest());
    }

    @Override
    public void setExp(int amount) {
        asPlayer().setExp(amount);
    }

    @Override
    public void addExp(int amount) {
        Player player = asPlayer();
        player.setExp(player.getExp() + amount);
    }

    @Override
    public void removeExp(int amount) {
        addExp(-amount);
    }

    @Override
    public void teleport(Location location) {
        asPlayer().teleport(location);
    }

    @Override
    public void heal(int amount) {
        Player player = asPlayer();
        player.setHealth(player.getHealth() + amount);
    }

    @Override
    public void damage(int amount) {
        heal(-amount);
    }

    @Override
    public World getWorld() {
        return asPlayer().getWorld();
    }

    @Override
    public Location getLocation() {
        return asPlayer().getLocation();
    }

    @Override
    public PlayerInventory getInventory() {
        return asPlayer().getInventory();
    }

    @Override
    public void performCommand(String command) {
        Player player = asPlayer();
        command = command.replace("%player%", player.getName());
        player.performCommand(command);
    }

    @Override
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

    @Override
    public ItemStack getPlayerHead() {
        return ItemBuilder.createPlayerHead(asOfflinePlayer());
    }

    @Override
    public void runFunction(Function function) {
        if (function != null) {
            function.run(this);
        }
    }

    @Override
    public void giveItem(ItemStack... items) {
        Player player = asPlayer();
        for (Map.Entry<Integer, ItemStack> entry : player.getInventory().addItem(Util.toNotNullArray(items)).entrySet()) {
            player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
        }
    }

}
