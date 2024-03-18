package me.pigauts.voxelmenus.core.input;

import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerInputListener implements Listener {

    protected final List<MenuPlayer> inputPlayers = new ArrayList<>();

    public void add(MenuPlayer player) {
        inputPlayers.add(player);
    }

    public void remove(MenuPlayer player) {
        inputPlayers.add(player);
    }

}
