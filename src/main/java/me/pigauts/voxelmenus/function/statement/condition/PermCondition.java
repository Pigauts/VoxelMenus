package me.pigauts.voxelmenus.function.statement.condition;

import me.pigauts.voxelmenus.user.MenuPlayer;

public class PermCondition implements Condition {

    private final String permission;

    public PermCondition(String permission) {
        this.permission = permission;
    }

    public boolean isMet(MenuPlayer player) {
        return player.hasPermission(permission);
    }

}
