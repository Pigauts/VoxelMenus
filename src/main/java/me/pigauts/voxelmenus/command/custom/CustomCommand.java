package me.pigauts.voxelmenus.command.custom;

import me.pigauts.voxelmenus.command.BaseCommand;

import java.util.List;

public abstract class CustomCommand extends BaseCommand {


    public CustomCommand(String name, String usageMessage, String description, List<String> aliases) {
        super(name, usageMessage, description, aliases);
    }

}
