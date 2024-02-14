package me.pigauts.voxelmenus.listener;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryEventsListener implements Listener {

    private final VoxelMenusPlugin plugin;

    public InventoryEventsListener(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {
        MenuPlayer player = plugin.getPlayers().getPlayer(event.getPlayer());
        if (player == null || !player.isViewingMenu()) return;

        if (event.getInventory() == player.getOpenView().getInventory()) return;

        player.setOpenView(null);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        MenuPlayer player = plugin.getPlayers().getPlayer(event.getPlayer());
        if (player == null || !player.isViewingMenu()) return;

        MenuView view = player.getOpenView();

        if (view.getMenu().keepOpen()) {
            player.openInventory(view.getTopInventory());
            return;
        }

        player.setOpenView(null);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        MenuPlayer player = plugin.getPlayers().getPlayer(event.getWhoClicked());
        if (player == null || !player.isViewingMenu()) return;

        player.clickMenu(event);
    }

}
