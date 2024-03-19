package me.pigauts.voxelmenus.core.function.condition;

import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.Factories;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConditionSet implements Condition {

    private final Condition[] conditions;

    public ConditionSet(Collection<Condition> conditions) {
        this.conditions = Util.toNotNullArray(conditions, new Condition[0]);
    }

    @Nullable
    public static Condition fromConfig(Config config) {
        if (config == null) return null;
        List<Condition> conditions = new ArrayList<>();

        for (String key : config.getKeys(false)) {
            Condition condition = config.getAtKey(Factories::createCondition, key);
            if (condition != null) {
                conditions.add(condition);
            }
        }

        return conditions.isEmpty() ? Condition.DEFAULT : new ConditionSet(conditions);
    }

    @Override
    public boolean isMet(MenuPlayer player) {
        for (Condition condition : conditions) {
            if (!condition.isMet(player)) return false;
        }
        return true;
    }

}
