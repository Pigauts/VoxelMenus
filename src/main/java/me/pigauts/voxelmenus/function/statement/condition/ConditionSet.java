package me.pigauts.voxelmenus.function.statement.condition;

import me.pigauts.voxelmenus.Helper;
import me.pigauts.voxelmenus.player.MenuPlayer;

import java.util.Collection;

public class ConditionSet implements Condition {

    private final Condition[] conditions;

    public ConditionSet(Collection<Condition> conditions) {
        this.conditions = Helper.toArray(conditions);
    }

    @Override
    public boolean isMet(MenuPlayer player) {
        for (Condition condition : conditions) {
            if (!condition.isMet(player)) return false;
        }
        return true;
    }

}
