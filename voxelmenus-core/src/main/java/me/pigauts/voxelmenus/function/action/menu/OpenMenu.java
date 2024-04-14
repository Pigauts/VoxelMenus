package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.function.Action;

public class OpenMenu implements Action {

    private final static VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    private final String menuName;

    public OpenMenu(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.openMenu(plugin.getMenus().getMenu(menuName));
    }

}
