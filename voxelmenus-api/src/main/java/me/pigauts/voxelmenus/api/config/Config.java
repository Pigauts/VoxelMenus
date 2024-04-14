package me.pigauts.voxelmenus.api.config;

import me.pigauts.voxelmenus.api.factory.ConfigFactory;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface Config extends ConfigurationSection, ValueHolder {

    File getFile();

    String getFileName();

    void createFile();

    void save();

    String getKey();

    String getAbsolutePath();

    String getAbsolutePath(String path);

    void validate(boolean condition, String path, String error) throws ConfigurationException;

    <T> T notNull(T notNull) throws ConfigurationException;

    <T> T notNull(T notNull, String path) throws ConfigurationException;

    <T> T create(ConfigFactory<T> factory);

    <T> T createNotNull(ConfigFactory<T> factory) throws ConfigurationException;

    <R> R create(String path, ConfigFactory<R> factory);

    <R> R createNotNull(String path, ConfigFactory<R> factory) throws ConfigurationException;

    UUID getUUID(String path);

    UUID getUUID(String path, UUID def);

    World getWorld(String path);

    World getWorld(String path, World def);

//    MenuPlayer getMenuPlayer(String path);
//
//    Menu getCustomMenu(String path);
//
//    Animation getCustomAnimation(String path);
//
//    Message getCustomMessage(String path);
//
//    Button getCustomButton(String path);

    boolean isSubSection(String path);

    Config getSubSection(String path);

    Set<Config> getSubSections();

    Set<Config> getSubSections(String path);

    Set<String> getKeys(String path, boolean deep);

    ItemStack getCustomItem(String path);

    Collection<ItemStack> getCustomItems(String path);

    Config getKeyOrSection(String path);

    boolean isSubKey(String path);

    Config getSubKey(String path);

    Set<String> getKeysPath(String path, boolean deep);

    Set<String> getKeysAbsolutePath(String path, boolean deep);

    String getString(String path);

    String getString(String path, String def);

    String getRawString(String path);

    String getRawString(String path, String def);

    <R> List<R> getList(ConfigFactory<R> factory);

    <R> List<R> getList(ConfigFactory<R> factory, String path);

    char getChar(String path);

    char getChar(String path, char def);

    float getFloat(String path);

    float getFloat(String path, float def);

    int getSecondsInTicks(String path);

    int getMinutesInTicks(String path);

    LocalDateTime getDate(String path);

    LocalDateTime getDate(String path, LocalDateTime def);

    String[][] get2DArray(String path);

    String[][] get2DArray(String path, int rows, int columns);

    <E extends Enum<E>> E getEnum(String path, Class<E> enumClass);

    <E extends Enum<E>> E getEnum(String path, Class<E> enumClass, E def);

    <E extends Enum<E>> List<E> getEnumList(String path, Class<E> enumClass);

    <E extends Enum<E>> List<E> getEnumList(Class<E> enumClass, String path);

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
