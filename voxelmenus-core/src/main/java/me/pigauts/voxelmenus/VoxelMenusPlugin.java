package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.api.VoxelMenus;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.config.ConfigSection;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VoxelMenusPlugin extends JavaPlugin implements VoxelMenus {

    private static VoxelMenusPlugin plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static VoxelMenusPlugin getPlugin() {
        return plugin;
    }

    public Config getConfig(String path) {
        return new ConfigSection(getFile(path));
    }

    public void createPluginFolder() {
        getDataFolder().mkdirs();
    }

    public File getFile(String path) {
        return new File(getDataFolder(), path);
    }

    public void createFolder(String path) {
        getFile(path).mkdirs();
    }

    public void createFile(String path) {
        if (!getFile(path).exists()) {
            saveResource(path, false);
        }
    }

    public void registerEvents(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public void registerCommand() {}

    public List<File> getFiles(String path) {
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

    public List<Config> getConfigs(String path) {

        List<Config> configs = new ArrayList<>();

        for (File file : getFiles(path)) {
            if (!file.getName().toLowerCase().endsWith(".yml")) continue;

            configs.add(new ConfigSection(file));
        }

        return configs;
    }

    public void disable() {
        getServer().getPluginManager().disablePlugin(this);
    }



}
