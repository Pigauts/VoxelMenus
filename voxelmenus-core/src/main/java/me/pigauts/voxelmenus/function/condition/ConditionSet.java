package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.api.function.Condition;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.util.Utils;

import java.util.Collection;

public class ConditionSet implements Condition {

    private final Condition[] conditions;

    public ConditionSet(Collection<Condition> conditions) {
        this.conditions = Utils.toNotNullArray(conditions, new Condition[0]);
    }

    @Override
    public boolean isMet(MenuPlayer player) {
        for (Condition condition : conditions) {
            if (!condition.isMet(player)) return false;
        }
        return true;
    }

}
