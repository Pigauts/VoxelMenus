package me.pigauts.voxelmenus.user;

import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.OpenMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class MenuPlayer {

    protected final UUID playerId;
    private final Set<String> flags = new HashSet<>();
    private OpenMenu openMenu = null;

    public MenuPlayer(UUID playerId) {
        this.playerId = playerId;
    }

    public UUID getUniqueId() {
        return playerId;
    }

    public Player asPlayer() {
        return Bukkit.getPlayer(playerId);
    }

    public OpenMenu getOpenMenu() {
        return openMenu;
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

    public Set<String> getFlags() {
        return flags;
    }

    public void registerFlag(String flag) {
        flags.add(flag);
    }

    public void unregisterFlag(String flag) {
        flags.remove(flag);
    }

    public void openMenu(Menu menu) {
        if (menu == null) return;
        this.openMenu = new OpenMenu(this, menu);
        openInventory(openMenu.getInventory());
    }

    public void openInventory(Inventory inventory) {
        asPlayer().openInventory(inventory);
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

    public Inventory getInventory() {
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

}
