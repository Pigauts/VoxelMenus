package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;

public class HealAction implements Action {

    private final int health;

    public HealAction(int health) {
        this.health = health;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.heal(health);
    }

}
