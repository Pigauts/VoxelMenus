package me.pigauts.voxelmenus.player;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private final VoxelMenusPlugin plugin;
    private final Map<UUID, MenuPlayer> players = new HashMap<>();

    public PlayerManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            players.put(player.getUniqueId(), plugin.getPlayerFactory().create(player));
        }
    }

    public MenuPlayer getPlayer(UUID userId) {
        return players.get(userId);
    }

    public MenuPlayer getPlayer(HumanEntity humanEntity) {
        return getPlayer(humanEntity.getUniqueId());
    }

    public void addUser(MenuPlayer user) {
        players.put(user.getUniqueId(), user);
    }

    public void addUser(Player player) {
        players.put(player.getUniqueId(), plugin.getPlayerFactory().create(player));
    }


    public void removeUser(MenuPlayer user) {
        removeUser(user.getUniqueId());
    }

    public void removeUser(Player player) {
        removeUser(player.getUniqueId());
    }

    public void removeUser(UUID playerId) {
        players.remove(playerId);
    }

    public Collection<MenuPlayer> getAllPlayers() {
        return players.values();
    }

}
