package me.pigauts.voxelmenus.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Deserialize {

    public static Location location(String raw) {
        String[] split = raw.replaceAll(" ", "").split(",");
        if (split.length == 3) {
            return new Location(Bukkit.getWorlds().get(0), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }

        if (split.length == 4) {
            return new Location(Bukkit.getWorld(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        }

        return null;
    }

}
