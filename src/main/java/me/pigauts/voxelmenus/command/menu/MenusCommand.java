package me.pigauts.voxelmenus.command.menu;

import me.pigauts.voxelmenus.command.BaseCommand;
import me.pigauts.voxelmenus.command.menu.subordinate.MenuOpenCmd;

import java.util.Arrays;

public class MenusCommand extends BaseCommand {

    public MenusCommand() {
        super("voxelmenus");
        this.description = "Main command for VoxelMenus";
        this.usageMessage = "/VoxelMenus";
        this.setAliases(Arrays.asList("vmenus", "menus"));
        this.setPermission("voxelmenus.admin");
        this.subCommands.add(new MenuOpenCmd());
    }

}
