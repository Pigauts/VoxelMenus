package me.pigauts.voxelmenus.core.config;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.animation.Animation;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.factory.Factory;
import me.pigauts.voxelmenus.core.holder.ValueHolder;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.message.Message;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface Config extends ConfigurationSection, ValueHolder {

    File getFile();

    String getFileName();

    void createFile();

    void save();

    String getKey();

    String getAbsolutePath(String path);

    void validate(boolean condition, String path, String error) throws ConfigurationException;

    <T> T validate(T notNull, String... keys) throws ConfigurationException;

    <R> R get(Factory<String, R> factory, String... keys);

    <R> R getNotNull(Factory<String, R> factory, String... keys) throws ConfigurationException;

    <R> R getAtSection(ConfigFactory<R> factory, String... keys);

    <R> R getNotNullAtSection(ConfigFactory<R> factory, String... keys) throws ConfigurationException;

    <R> R getAtKey(ConfigKeyFactory<R> factory, String... keys);

    <R> R getNotNullAtKey(ConfigKeyFactory<R> factory, String... keys) throws ConfigurationException;

    UUID getUUID(String path);

    UUID getUUID(String path, UUID def);

    World getWorld(String path);

    World getWorld(String path, World def);

    MenuPlayer getMenuPlayer(String path);

    Menu getCustomMenu(String path);

    Animation getCustomAnimation(String path);

    Message getCustomMessage(String path);

    Button getCustomButton(String path);

    boolean isSubSection(String path);

    Config getSubSection(String path);

    Set<Config> getSubSections();

    Set<Config> getSubSections(String path);

    Set<String> getKeys(String path, boolean deep);

    Set<String> getKeysPath(String path, boolean deep);

    Set<String> getKeysAbsolutePath(String path, boolean deep);

    String getString(String path);

    String getString(String path, String def);

    String getRawString(String path);

    String getRawString(String path, String def);

    char getChar(String path);

    char getChar(String path, char def);

    float getFloat(String path);

    float getFloat(String path, float def);

    int getSecondsInTicks(String path);

    int getMinutesInTicks(String path);

    LocalDateTime getDate(String path);

    LocalDateTime getDate(String path, LocalDateTime def);

    <E extends Enum<E>> E getEnum(String path, Class<E> enumClass);

    <E extends Enum<E>> E getEnum(String path, Class<E> enumClass, E def);

    <E extends Enum<E>> List<E> getEnumList(String path, Class<E> enumClass);

    List<ClickType> getClickList(String path);

    Material getMaterial(String path);

    Material getMaterial(String path, Material def);

    InventoryType getInventory(String path);

    InventoryType getInventory(String path, InventoryType def);

    BarColor getBarColor(String path);

    BarColor getBarColor(String path, BarColor def);

    BarStyle getBarStyle(String path);

    BarStyle getBarStyle(String path, BarStyle def);

}
