package me.pigauts.voxelmenus.function.condition;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

public class PermCondition implements Condition {

    private final String permission;

    public PermCondition(String permission) {
        this.permission = permission;
    }

    public boolean isMet(MenuPlayer player) {
        return player.hasPermission(permission);
    }

}
