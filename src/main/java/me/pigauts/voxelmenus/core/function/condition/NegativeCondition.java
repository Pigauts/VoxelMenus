package me.pigauts.voxelmenus.core.function.condition;

import me.pigauts.voxelmenus.API.MenuPlayer;

public class NegativeCondition implements Condition {

    private final Condition condition;

    public NegativeCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public boolean isMet(MenuPlayer player) {
        return !condition.isMet(player);
    }

}
