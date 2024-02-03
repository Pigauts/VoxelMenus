package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.user.MenuPlayer;

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
