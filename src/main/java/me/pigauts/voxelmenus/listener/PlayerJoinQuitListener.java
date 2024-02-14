package me.pigauts.voxelmenus.listener;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {

    private final VoxelMenusPlugin plugin;

    public PlayerJoinQuitListener(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        plugin.getPlayers().addUser(event.getPlayer());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        plugin.getPlayers().removeUser(event.getPlayer());

    }

}
