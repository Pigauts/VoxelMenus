package me.pigauts.voxelmenus.command.subordinate;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface SubCommand {

    String getName();

    int getMinArgs();

    int getMaxArgs();

    boolean canBeExecutedByConsole();

    void execute(CommandSender sender, String[] args);

}
