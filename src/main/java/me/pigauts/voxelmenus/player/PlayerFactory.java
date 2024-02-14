package me.pigauts.voxelmenus.player;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PlayerFactory {

    @NotNull
    MenuPlayer create(@NotNull Player player);

}

class MenuPlayerFactory implements PlayerFactory {

    @Override
    public MenuPlayer create(Player player) {
        return new MenuPlayer(player.getUniqueId());
    }

}
