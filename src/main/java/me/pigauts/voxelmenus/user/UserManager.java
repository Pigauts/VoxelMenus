package me.pigauts.voxelmenus.user;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    private final VoxelMenusPlugin menusPlugin;

    private PlayerFactory userFactory = new MenuPlayerFactory();

    private final Map<UUID, MenuPlayer> usersByUUID = new HashMap<>();

    public UserManager(VoxelMenusPlugin menusPlugin) {
        this.menusPlugin = menusPlugin;
    }

    public void load() {
        for (Player player : Bukkit.getOnlinePlayers())
            usersByUUID.put(player.getUniqueId(), new MenuPlayer(player.getUniqueId()));
    }

    public void setUserFactory(@NotNull PlayerFactory userFactory) {
        this.userFactory = userFactory;
    }

    public MenuPlayer getUser(UUID userId) {
        return usersByUUID.get(userId);
    }

    public MenuPlayer getUser(HumanEntity humanEntity) {
        return getUser(humanEntity.getUniqueId());
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

}
