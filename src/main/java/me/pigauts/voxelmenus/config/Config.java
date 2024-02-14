package me.pigauts.voxelmenus.config;

import me.pigauts.voxelmenus.Helper;
import me.pigauts.voxelmenus.item.ItemBuilder;
import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Config implements ConfigurationSection {

    private final File file;

    private final ConfigurationSection section;

    public Config(File file) {
        this.file = file;
        this.section = YamlConfiguration.loadConfiguration(file);
    }

    public Config(File file, ConfigurationSection section) {
        this.file = file;
        this.section = section;
    }

    public boolean isEmpty() {
        return file.exists() && file.length() > 0;
    }

    public void create() {
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) { }
    }

    public void save() {
        if (!file.exists()) create();
        if (!(section instanceof YamlConfiguration yamlConfig)) return;
        try {
            yamlConfig.save(file);
        } catch (IOException e) { }
    }

    public Map<String, Object> getValues(boolean deep) {
        return section.getValues(deep);
    }

    public boolean contains(String path) {
        return section.contains(path);
    }

    public boolean contains(String path, boolean ignoreDefault) {
        return section.contains(path, ignoreDefault);
    }

    public boolean isSet(String path) {
        return section.isSet(path);
    }

    public String getCurrentPath() {
        return section.getCurrentPath();
    }

    public String getName() {
        return file.getName().replace(".yml", "");
    }

    public Configuration getRoot() {
        return section.getRoot();
    }

    public ConfigurationSection getParent() {
        return section.getParent();
    }

    public Object get(String path) {
        return section.get(path);
    }

    public Object get(String path, Object def) {
        return section.get(path, def);
    }

    public void set(String path, Object value) {
        section.set(path, value);
    }

    public ConfigurationSection createSection(String path) {
        return section.createSection(path);
    }

    public ConfigurationSection createSection(String path, Map<?, ?> map) {
        return section.createSection(path, map);
    }

    public char getChar(String path) {
        return getChar(path, '0');
    }

    public char getChar(String path, char def) {
        String string = getString(path);
        return string.isEmpty() ? def : string.charAt(0);
    }

    public boolean stringEquals(String path, @NotNull String value) {
        return value.equalsIgnoreCase(section.getString(path));
    }

    public String getString(String path) {
        return section.getString(path);
    }

    public String getString(String path, String def) {
        return section.getString(path, def);
    }

    public boolean isString(String path) {
        return section.isString(path);
    }

    public int getInt(String path) {
        return section.getInt(path);
    }

    public int getInt(String path, int def) {
        return section.getInt(path, def);
    }

    public boolean isInt(String path) {
        return section.isInt(path);
    }

    public boolean getBoolean(String path) {
        return section.getBoolean(path);
    }

    public boolean getBoolean(String path, boolean def) {
        return section.getBoolean(path, def);
    }

    public boolean isBoolean(String path) {
        return section.isBoolean(path);
    }

    public double getDouble(String path) {
        return section.getDouble(path);
    }

    public double getDouble(String path, double def) {
        return section.getDouble(path, def);
    }

    public boolean isDouble(String path) {
        return section.isDouble(path);
    }

    public long getLong(String path) {
        return section.getLong(path);
    }

    public long getLong(String path, long def) {
        return section.getLong(path, def);
    }

    public boolean isLong(String path) {
        return section.isLong(path);
    }

    public List<?> getList(String path) {
        return section.getList(path);
    }

    public List<?> getList(String path, List<?> def) {
        return section.getList(path, def);
    }

    public boolean isList(String path) {
        return section.isList(path);
    }

    public List<String> getStringList(String path) {
        return section.getStringList(path);
    }

    public List<Integer> getIntegerList(String path) {
        return section.getIntegerList(path);
    }

    public List<Boolean> getBooleanList(String path) {
        return section.getBooleanList(path);
    }

    public List<Double> getDoubleList(String path) {
        return section.getDoubleList(path);
    }

    public List<Float> getFloatList(String path) {
        return section.getFloatList(path);
    }

    public List<Long> getLongList(String path) {
        return section.getLongList(path);
    }

    public List<Byte> getByteList(String path) {
        return section.getByteList(path);
    }

    public List<Character> getCharacterList(String path) {
        return section.getCharacterList(path);
    }

    public List<Short> getShortList(String path) {
        return section.getShortList(path);
    }

    public List<Map<?, ?>> getMapList(String path) {
        return section.getMapList(path);
    }

    public <T> T getObject(String path, Class<T> clazz) {
        return section.getObject(path, clazz);
    }

    public <T> T getObject(String path, Class<T> clazz, T def) {
        return section.getObject(path, clazz, def);
    }

    public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> clazz) {
        return section.getSerializable(path, clazz);
    }

    public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> clazz, T def) {
        return section.getSerializable(path, clazz, def);
    }

    public Vector getVector(String path) {
        return section.getVector(path);
    }

    public Vector getVector(String path, Vector def) {
        return section.getVector(path, def);
    }

    public boolean isVector(String path) {
        return section.isVector(path);
    }

    public OfflinePlayer getOfflinePlayer(String path) {
        return section.getOfflinePlayer(path);
    }

    public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def) {
        return section.getOfflinePlayer(path, def);
    }

    public boolean isOfflinePlayer(String path) {
        return section.isOfflinePlayer(path);
    }

    public boolean isItemStack(String path) {
        return section.isItemStack(path);
    }

    public Color getColor(String path) {
        return section.getColor(path);
    }

    public Color getColor(String path, Color def) {
        return section.getColor(path, def);
    }

    public boolean isColor(String path) {
        return section.isColor(path);
    }

    public Location getLocation(String path) {
        return section.getLocation(path);
    }

    public Location getLocation(String path, Location def) {
        return section.getLocation(path, def);
    }

    public boolean isLocation(String path) {
        return section.isLocation(path);
    }

    public ConfigurationSection getConfigurationSection(String path) {
        return section.getConfigurationSection(path);
    }

    public boolean isConfigurationSection(String path) {
        return section.isConfigurationSection(path);
    }

    public boolean isSection(String path) {
        return section.isConfigurationSection(path);
    }

    public boolean areSections(String... paths) {
        for (String path : paths) {
            if (!isSection(path)) return false;
        }
        return true;
    }

    public ConfigurationSection getDefaultSection() {
        return section.getDefaultSection();
    }

    public void addDefault(String path, Object value) {
        section.addDefault(path, value);
    }

    public List<String> getComments(String path) {
        return section.getComments(path);
    }

    public List<String> getInlineComments(String path) {
        return section.getInlineComments(path);
    }

    public void setComments(String path, List<String> comments) {
        section.setComments(path, comments);
    }

    public void setInlineComments(String path, List<String> comments) {
        section.setInlineComments(path, comments);
    }

    public Set<String> getKeys(boolean deep) {
        return section.getKeys(deep);
    }

    public Set<String> getKeys(String path, boolean deep) {
        if (!section.isConfigurationSection(path)) return Collections.EMPTY_SET;
        return section.getConfigurationSection(path).getKeys(deep);
    }

    public List<Config> getSections() {
        List<Config> sections = new ArrayList<>();

        for (String key : getKeys(false)) {
            if (!isSection(key)) continue;
            sections.add(getSection(key));
        }

        return sections;
    }

    public Config getSection(String path) {
        return isSection(path) ? new Config(file, getConfigurationSection(path)) : null;
    }

    public List<Config> getSections(String path) {
        List<Config> sections = new ArrayList<>();

        for (String keyPath : getKeysPath(path, false)) {
            if (!isSection(keyPath)) continue;
            sections.add(getSection(keyPath));
        }

        return sections;
    }

    public Set<String> getKeysPath(String path, boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(path, deep)) {
            paths.add(Helper.buildPath(path, key));
        }

        return paths;
    }

    public Set<String> getKeysAbsolutePath(boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(deep)) {
            paths.add(Helper.buildPath(section.getCurrentPath(), key));
        }

        return paths;
    }

    public Set<String> getKeysAbsolutePath(String path, boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(path, deep)) {
            paths.add(Helper.buildPath(section.getCurrentPath(), path, key));
        }

        return paths;
    }

    public String getColorString(String path) {
        return ChatColor.translateAlternateColorCodes('&', section.getString(path, ""));
    }

    public String getColorString(String path, String defaultValue) {
        return ChatColor.translateAlternateColorCodes('&', section.getString(path, defaultValue));
    }

    public int getSecondsInTicks(String path) {
        return section.getInt(path, 0) * 20;
    }

    public int getMinutesInTicks(String path) {
        return (section.getInt(path, 0) * 60) * 20;
    }

    public LocalDateTime getDate(String path) {
        return !isSet(path) ? null : LocalDateTime.parse(section.getString(path));
    }

    public <E extends Enum<E>> E getEnum(Class<E> enumClass, String path) {
        return Helper.getEnum(enumClass, section.getString(path, "").replace(" ", "_").toUpperCase());
    }

    public <E extends Enum<E>> List<E> getEnumList(Class<E> enumClass, String path) {
        List<E> enumList = new ArrayList<>();

        for (String enumName : section.getStringList(path)) {
            E enumValue = Helper.getEnum(enumClass, enumName);
            if (enumValue == null) continue;

            enumList.add(enumValue);
        }

        return enumList;
    }

    public <E extends Enum<E>> Set<E> getEnumSet(Class<E> enumClass, String path) {
        Set<E> enumSet = new HashSet<>();

        for (String enumName : section.getStringList(path)) {
            E enumValue = Helper.getEnum(enumClass, enumName);
            if (enumValue == null) continue;

            enumSet.add(enumValue);
        }

        return enumSet;
    }

    public Material getMaterial(String path) {
        return getEnum(Material.class, path);
    }

    public Material getMaterial(String path, Material def) {
        Material material = getMaterial(path);
        return material != null ? material : def;
    }

    public ItemStack getItemStack(String path) {
        if (isItemStack(path)) {
            return section.getItemStack(path);
        }
        return new ItemBuilder(getSection(path)).build();
    }

    public ItemStack getItemStack(String path, ItemStack def) {
        if (isItemStack(path)) {
            return section.getItemStack(path);
        }
        return def;
    }

//    public ItemStack getCustomItem(String path) {
//        if (DailyShopPlugin.get().getItems().getItem(getString(path)) == null) {
//            if (isMaterial(path)) return new ItemStack(getMaterial(path));
//        }
//        return DailyShopPlugin.get().getItems().getItem(getString(path));
//    }

//    public ItemStack getCustomItem(String path, ItemStack defaultValue) {
//        if (getCustomItem(path) != null) return getCustomItem(path);
//        if (defaultValue != null) return defaultValue;
//        if (isMaterial(path)) return new ItemStack(getMaterial(path));
//        return new ItemStack(Material.DIRT);
//    }

    public UUID getUUID(UUID defaultValue, String path) {
        return UUID.fromString(section.getString(path, defaultValue.toString()));
    }

    public UUID getUUID(String path) {
        return UUID.fromString(section.getString(path, ""));
    }

    public List<String> getLayout(String path) {
        List<String> layout = new ArrayList<>();

        for (String row : getStringList(path)) {
            String[] columns = row.split(" ");

            for (int i = 0; i < 9; i++) {
                if (columns.length < i || Helper.NULL_CHARACTERS.contains(columns[i])) {
                    layout.add(null);
                    continue;
                }

                layout.add(columns[i]);
            }
        }
        return layout;
    }



}