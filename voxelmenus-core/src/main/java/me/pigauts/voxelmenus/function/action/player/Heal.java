package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

public class Heal implements Action {

    private final int health;

    public Heal(int health) {
        this.health = health;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.heal(health);
    }

}
