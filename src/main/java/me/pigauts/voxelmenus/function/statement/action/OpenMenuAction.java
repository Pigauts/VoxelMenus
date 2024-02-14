package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.player.MenuPlayer;

public class OpenMenuAction implements Action {

    private final static VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    private final String menuName;

    public OpenMenuAction(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.openMenu(plugin.getMenus().getMenu(menuName));
    }

}
