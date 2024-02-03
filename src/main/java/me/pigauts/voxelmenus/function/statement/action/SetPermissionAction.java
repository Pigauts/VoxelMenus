package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.user.MenuPlayer;

public class SetPermissionAction implements Action {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.get();

    private final String name;
    private final boolean value;

    public SetPermissionAction(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.asPlayer().addAttachment(plugin, name, value);
    }

}
