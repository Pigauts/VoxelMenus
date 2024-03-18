package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.API.MenusPlugin;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Deserialize {

    private static final MenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    public static Location location(String raw) {
        String[] split = raw.replaceAll(" ", "").split(",");
        if (split.length == 3) {
            return new Location(plugin.getWorld(), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }

        if (split.length == 4) {
            return new Location(Bukkit.getWorld(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        }

        return null;
    }

}
