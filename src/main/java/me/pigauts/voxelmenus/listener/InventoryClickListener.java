package me.pigauts.voxelmenus.listener;

import me.pigauts.voxelmenus.Helper;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.event.MenuClickEvent;
import me.pigauts.voxelmenus.menu.OpenMenu;
import me.pigauts.voxelmenus.user.MenuPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private final VoxelMenusPlugin plugin;

    public InventoryClickListener(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        MenuPlayer user = plugin.getUsers().getUser(event.getWhoClicked());

        if (user == null) return;

        OpenMenu openMenu = user.getOpenMenu();

        if (openMenu == null) return;

        event.setCancelled(true);

        MenuClickEvent menuClickEvent = new MenuClickEvent(user, openMenu, event);
        VoxelPlugin.callEvent(menuClickEvent);

//        if (slot >= 0 && slot < openMenu.getSize())

        if (!menuClickEvent.isCancelled())
            openMenu.onClick(menuClickEvent);

    }

}
