package me.pigauts.voxelmenus.player;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuPlayerManager {

    private final VoxelMenusPlugin menusPlugin;

    private PlayerFactory userFactory = new MenuPlayerFactory();

    private final Map<UUID, MenuPlayer> usersByUUID = new HashMap<>();

    public MenuPlayerManager(VoxelMenusPlugin menusPlugin) {
        this.menusPlugin = menusPlugin;
    }

    public void load() {
        for (Player player : Bukkit.getOnlinePlayers())
            usersByUUID.put(player.getUniqueId(), new MenuPlayer(player.getUniqueId()));
    }

    public void setUserFactory(@NotNull PlayerFactory userFactory) {
        this.userFactory = userFactory;
    }

    public MenuPlayer getPlayer(UUID userId) {
        return usersByUUID.get(userId);
    }

    public MenuPlayer getPlayer(HumanEntity humanEntity) {
        return getPlayer(humanEntity.getUniqueId());
    }

    public void addUser(MenuPlayer user) {
        usersByUUID.put(user.getUniqueId(), user);
    }

    public void addUser(Player player) {
        usersByUUID.put(player.getUniqueId(), userFactory.create(player));
    }


    public void removeUser(MenuPlayer user) {
        removeUser(user.getUniqueId());
    }

    public void removeUser(Player player) {
        removeUser(player.getUniqueId());
    }

    public void removeUser(UUID playerId) {
        usersByUUID.remove(playerId);
    }

    public Collection<MenuPlayer> getAllPlayers() {
        return usersByUUID.values();
    }

}
