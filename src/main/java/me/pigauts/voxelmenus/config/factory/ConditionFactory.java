package me.pigauts.voxelmenus.config.factory;

import me.pigauts.voxelmenus.Helper;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.function.statement.condition.FlagCondition;
import me.pigauts.voxelmenus.function.statement.condition.PermCondition;

public class ConditionFactory {

    public Condition createCondition(String key, Object value) {

        switch (key) {

            case "PERMISSION":
                String perm = Helper.cast(value, String.class);
                if (perm != null) return new PermCondition(perm);
                break;

            case "FLAG":
                String flag = Helper.cast(value, String.class);
                if (flag != null) return new FlagCondition(flag);
                break;

            default:
                break;

        }

        return null;
    }

}
