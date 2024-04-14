package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

public class Damage implements Action {

    private final int health;

    public Damage(int health) {
        this.health = -health;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.heal(health);
    }

}
