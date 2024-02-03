package me.pigauts.voxelmenus.command;

import me.pigauts.voxelmenus.command.subordinate.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseCommand extends BukkitCommand {

    protected final Set<SubCommand> subCommands = new HashSet<>();

    public BaseCommand(String name) {
        super(name);
    }

    public BaseCommand(String name, String usageMessage, String description, List<String> aliases) {
        super(name, usageMessage, description, aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {

        if (args.length < 1) {
            sender.sendMessage("HELP YOU");
            return true;
        }

        for (SubCommand subCommand : subCommands) {
            if (!subCommand.getName().equalsIgnoreCase(args[0])) continue;

            if (subCommand.getMinArgs() > args.length) {
                sender.sendMessage("Not enough arguments!");
                break;
            }

            if (subCommand.getMaxArgs() < args.length) {
                sender.sendMessage("Too many arguments!");
                break;
            }

            if (!subCommand.canBeExecutedByConsole() && !(sender instanceof Player player)) {
                sender.sendMessage("This command can't be executed from console");
                break;
            }

            subCommand.execute(sender, args);
            return true;
        }

        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String label, String[] args) {

        final List<String> completions = new ArrayList<>();

        for (SubCommand subCommand : subCommands) {

        }

        return completions;
    }

}
