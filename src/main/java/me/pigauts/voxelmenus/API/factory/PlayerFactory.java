package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.factory.Factory;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface PlayerFactory extends Factory<Player, MenuPlayer> {

    @Override
    MenuPlayer create(@NotNull Player player);

}
