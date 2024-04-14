package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Condition;

public class FlagCondition implements Condition {

    private final String flag;

    public FlagCondition(String flag) {
        this.flag = flag;
    }

    public boolean isMet(MenuPlayer user) {
        return user.hasFlag(flag);
    }

}
