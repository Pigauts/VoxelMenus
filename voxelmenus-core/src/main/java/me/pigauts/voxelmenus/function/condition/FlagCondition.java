package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

public class FlagCondition implements Condition {

    private final String flag;

    public FlagCondition(String flag) {
        this.flag = flag;
    }

    public boolean isMet(MenuPlayer user) {
        return user.hasFlag(flag);
    }

}
