package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class DamageAction implements Action {

    private final int health;

    public DamageAction(int health) {
        this.health = -health;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.heal(health);
    }

}
