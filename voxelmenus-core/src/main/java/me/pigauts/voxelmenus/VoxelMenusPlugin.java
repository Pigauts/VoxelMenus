package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.api.VoxelMenus;
import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.factory.*;
import me.pigauts.voxelmenus.api.flag.Flag;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.MenuEntryButtons;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

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


    @Override
    public @NotNull World getWorld() {
        return null;
    }

    @Override
    public @Nullable MenuPlayer getPlayer(UUID playerId) {
        return null;
    }

    @Override
    public @Nullable Menu getMenu(String menuId) {
        return null;
    }

    @Override
    public @Nullable ItemStack getItem(String itemId) {
        return null;
    }

    @Override
    public @Nullable Flag getFlag(String flagId) {
        return null;
    }

    @Override
    public @NotNull List<ItemStack> getItems(Collection<String> itemsIds) {
        return null;
    }

    @Override
    public @Nullable TemplateButton getTemplateButton(String iconId) {
        return null;
    }

    @Override
    public @Nullable Function getFunction(String functionId) {
        return null;
    }

    @Override
    public @Nullable Animation getAnimation(String animationId) {
        return null;
    }

    @Override
    public @Nullable Message getMessage(String messageId) {
        return null;
    }

    @Override
    public @Nullable MenuEntryButtons getEntries(String entriesId) {
        return null;
    }

    @Override
    public @Nullable MenuFactory getMenuFactory(String factoryId) {
        return null;
    }

    @Override
    public @Nullable MessageFactory getMessageFactory(String factoryId) {
        return null;
    }

    @Override
    public @NotNull PlayerFactory getPlayerFactory() {
        return null;
    }

    @Override
    public @Nullable FunctionFactory getFunctionFactory(String factoryId) {
        return null;
    }

    @Override
    public @Nullable ConditionFactory getConditionFactory(String factoryId) {
        return null;
    }

    @Override
    public @Nullable ActionFactory getActionFactory(String factoryId) {
        return null;
    }

}
