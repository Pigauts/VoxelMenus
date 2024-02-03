package me.pigauts.voxelmenus.command;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, Command> commandsByName = new HashMap<>();

    public CommandManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public void addCommand(Command command) {
        commandsByName.put(command.getName(), command);
    }

    public void registerAll() {

        CommandMap commandMap = getCommandMap();

        for (Map.Entry<String, Command> entry : commandsByName.entrySet()) {
            commandMap.register(entry.getKey(), entry.getValue());
        }

    }

    public void unregisterAll() {
        CommandMap commandMap = getCommandMap();
        Map<String, Command> knownCommands = getKnownCommands(commandMap);

        for (Map.Entry<String, Command> entry : commandsByName.entrySet()) {
            knownCommands.remove(entry.getKey());
            entry.getValue().unregister(commandMap);
        }
    }

    private CommandMap getCommandMap() {
        try {
            final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            return (CommandMap) commandMapField.get(Bukkit.getServer());
        } catch (NoSuchFieldException  | IllegalArgumentException | IllegalAccessException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private Map<String, Command> getKnownCommands(CommandMap commandMap) {
        try {
            final Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
            knownCommandsField.setAccessible(true);
            return (Map<String, Command>) knownCommandsField.get(commandMap);
        } catch (NoSuchFieldException  | IllegalArgumentException | IllegalAccessException exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
