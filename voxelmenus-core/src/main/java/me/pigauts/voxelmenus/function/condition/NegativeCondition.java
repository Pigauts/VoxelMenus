package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

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
