package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public interface VoxelPlugin extends Plugin {

    static void callEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

    default Config getConfig(String... path) {
        return new Config(getFile(path));
    }

    default void createPluginFolder() {
        getDataFolder().mkdirs();
    }

    default File getFile(String... path) {
        return new File(getDataFolder(), Helper.buildPath(path));
    }

    default void createFolder(String... path) {
        getFile(path).mkdirs();
    }

    default void saveDefaultFile(String... path) {
        if (!getFile(path).exists())
            saveResource(Helper.buildPath(path), false);
    }

    default void registerEvents(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

//    default void registerCommand(PluginCommand command, CommandManager manager, CommandRegistry registry) {
//        registry.registerCommands(manager);
//        command.setExecutor(manager);
//    }

    default Set<File> getFiles(String... path) {
        Set<File> fileList = new HashSet<>();
        try {
            Files.walk(getFile(path).toPath())
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .forEach(fileList::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileList;
    }

    default Set<Config> getConfigs(String... path) {

        Set<Config> configs = new HashSet<>();

        for (File file : getFiles(path)) {
            if (!file.getName().toLowerCase().endsWith(".yml")) continue;
            configs.add(new Config(file));
        }

        return configs;
    }

}
