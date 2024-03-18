package me.pigauts.voxelmenus.command.menu.subordinate;

import me.pigauts.voxelmenus.command.subordinate.UserCommand;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class MenuOpenCmd extends UserCommand {

    public String getName() {
        return "open";
    }

    public int getMinArgs() {
        return 2;
    }

    public int getMaxArgs() {
        return 2;
    }

    public void execute(MenuPlayer user, String[] args) {
        user.openMenu(plugin.getMenus().getMenu(args[1]));
    }

}
