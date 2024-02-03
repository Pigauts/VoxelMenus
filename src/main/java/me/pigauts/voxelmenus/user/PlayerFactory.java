package me.pigauts.voxelmenus.user;

import org.bukkit.entity.Player;

public interface PlayerFactory {

    MenuPlayer create(Player player);

}

class MenuPlayerFactory implements PlayerFactory {

    @Override
    public MenuPlayer create(Player player) {
        return new MenuPlayer(player.getUniqueId());
    }

}
