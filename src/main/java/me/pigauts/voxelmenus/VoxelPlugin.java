package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.core.config.ConfigSection;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface VoxelPlugin extends Plugin {

    static void callEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

    default ConfigSection getConfig(String path) {
        return new ConfigSection(getFile(path));
    }

    default void createPluginFolder() {
        getDataFolder().mkdirs();
    }

    default File getFile(String path) {
        return new File(getDataFolder(), path);
    }

    default void createFolder(String path) {
        getFile(path).mkdirs();
    }

    default void createFile(String path) {
        if (!getFile(path).exists()) {
            saveResource(path, false);
        }
    }

    default void registerEvents(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

//    default void registerCommand(PluginCommand command, CommandManager manager, CommandRegistry registry) {
//        registry.registerCommands(manager);
//        command.setExecutor(manager);
//    }

    default List<File> getFiles(String path) {
        List<File> fileList = new ArrayList<>();
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

    default List<ConfigSection> getConfigs(String path) {

        List<ConfigSection> configs = new ArrayList<>();

        for (File file : getFiles(path)) {
            if (!file.getName().toLowerCase().endsWith(".yml")) continue;

            configs.add(new ConfigSection(file));
        }

        return configs;
    }

    default void disable() {
        getServer().getPluginManager().disablePlugin(this);
    }

}
