package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.player.MenuPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface PlayerFactory extends Factory<Player, MenuPlayer> {

    @Override
    MenuPlayer create(@NotNull Player player);

}
