package me.pigauts.voxelmenus.core.listener;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.runnable.MenusScheduler;
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


    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        MenuPlayer player = plugin.getPlayers().getPlayer(event.getPlayer());
        if (player == null || !player.isViewingMenu()) return;

        MenuView view = player.getOpenView();

        if (view.getMenu().keepOpen()) {
            MenusScheduler.runTaskLater(1, () -> player.openInventory(event.getInventory()));
            return;
        }

        player.setOpenView(null);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        MenuPlayer player = plugin.getPlayers().getPlayer(event.getWhoClicked());
        if (player == null) return;

        player.clickMenu(event);
    }

}
