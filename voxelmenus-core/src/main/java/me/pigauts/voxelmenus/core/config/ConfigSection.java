package me.pigauts.voxelmenus.core.config;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.config.ConfigurationException;
import me.pigauts.voxelmenus.api.factory.ConfigFactory;
import me.pigauts.voxelmenus.item.ItemBuilder;
import me.pigauts.voxelmenus.util.Deserialize;
import me.pigauts.voxelmenus.util.Pair;
import me.pigauts.voxelmenus.util.Utils;
import org.apache.commons.lang.Validate;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

import static me.pigauts.voxelmenus.util.Utils.pathOf;

public class ConfigSection implements Config {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    protected final File file;
    protected final ConfigurationSection section;

    public ConfigSection(File file) {
        this(file, YamlConfiguration.loadConfiguration(file));
    }

    public ConfigSection(File file, ConfigurationSection section) {
        Validate.notNull(file, "File can't be null");
        Validate.notNull(section, "Configuration section can't be null");
        this.file = file;
        this.section = section;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String getFileName() {
        return file.getName();
    }

    @Override
    public void createFile() {
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    @Override
    public void save() {
        if (!file.exists()) createFile();
        if (!(section instanceof YamlConfiguration yamlConfig)) return;
        try {
            yamlConfig.save(file);
        } catch (IOException e) {
        }
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public String getAbsolutePath() {
        return section.getCurrentPath();
    }

    @Override
    public String getAbsolutePath(String path) {
        return pathOf(section.getCurrentPath(), path);
    }

    @Override
    public void validate(boolean condition, String path, String error) throws ConfigurationException {
        if (condition) return;
        throw new ConfigurationException(String.format("Mistake found in file '%s' at key '%s': %s", file.getPath(), getAbsolutePath(path), error));
    }

    @Override
    public <T> T notNull(T notNull) throws ConfigurationException {
        return notNull(notNull, getAbsolutePath());
    }

    @Override
    public <T> T notNull(T notNull, String path) throws ConfigurationException {
        if (notNull != null) return notNull;
        throw new ConfigurationException(String.format("Mistake found in file '%s' at key '%s': %s", file.getPath(), getAbsolutePath(path), "Value is not set or invalid"));
    }

    @Override
    public <T> T create(ConfigFactory<T> factory) {
        return factory.create(this);
    }

    @Override
    public <T> T createNotNull(ConfigFactory<T> factory) throws ConfigurationException {
        return notNull(create(factory));
    }

    @Override
    public <R> R create(String path, ConfigFactory<R> factory) {
        return factory.create(getKeyOrSection(path));
    }

    public <R> R createNotNull(String path, ConfigFactory<R> factory) throws ConfigurationException {
        return notNull(create(path, factory), path);
    }

    @Override
    public UUID getUUID(String path) {
        return Utils.getUUID(getString(path));
    }

    @Override
    public UUID getUUID(String path, UUID def) {
        UUID uuid;
        return (uuid = getUUID(path)) == null ? def : uuid;
    }

    @Override
    public World getWorld(String path) {
        return Bukkit.getWorld(getRawString(path));
    }

    @Override
    public World getWorld(String path, World def) {
        World world;
        return (world = getWorld(path)) == null ? def : world;
    }

//    @Override
//    public MenuPlayer getMenuPlayer(String path) {
//        return plugin.getPlayer(getUUID(path));
//    }
//
//    @Override
//    public Menu getCustomMenu(String path) {
//        return plugin.getMenu(getRawString(path));
//    }
//
//    @Override
//    public Animation getCustomAnimation(String path) {
//        return plugin.getAnimation(getRawString(path));
//    }
//
//    @Override
//    public Message getCustomMessage(String path) {
//        return plugin.getMessage(getRawString(path));
//    }
//
//    @Override
//    public Button getCustomButton(String path) {
//        return plugin.getCustomButton(getRawString(path));
//    }

    @Override
    public boolean isSubSection(String path) {
        return isConfigurationSection(path);
    }

    @Override
    public Config getSubSection(String path) {
        if (!isSubSection(path)) return null;
        return new ConfigSection(file, getConfigurationSection(path));
    }

    @Override
    public Set<Config> getSubSections() {
        Set<Config> sections = new HashSet<>();

        for (String key : getKeys(false)) {
            Config section = getSubSection(key);

            if (section != null) {
                sections.add(section);
            }
        }

        return sections;
    }

    @Override
    public Set<Config> getSubSections(String path) {
        Set<Config> sections = new HashSet<>();

        for (String key : getKeysPath(path, false)) {
            Config section = getSubSection(key);

            if (section != null) {
                sections.add(section);
            }
        }

        return sections;
    }

    @Override
    public Set<String> getKeys(String path, boolean deep) {
        if (!isSubSection(path)) return Collections.EMPTY_SET;
        return section.getConfigurationSection(path).getKeys(deep);
    }

    @Override
    public String getRawString(String path) {
        return section.getString(path);
    }

    @Override
    public String getRawString(String path, String def) {
        return section.getString(path, def);
    }

    @Override
    public <R> List<R> getList(ConfigFactory<R> factory) {
        List<R> list = new ArrayList<>();

        for (Config key : getSubSections()) {
            R result = factory.create(key);

            if (result != null) {
                list.add(result);
            }
        }

        return list;
    }

    @Override
    public <R> List<R> getList(ConfigFactory<R> factory, String path) {
        List<R> list = new ArrayList<>();

        for (Config key : getSubSections(path)) {
            R result = factory.create(key);

            if (result != null) {
                list.add(result);
            }
        }

        return list;
    }

    @Override
    public char getChar(String path) {
        return getChar(path, '0');
    }

    @Override
    public char getChar(String path, char def) {
        String string = getString(path);
        return string.isEmpty() ? def : string.charAt(0);
    }

    @Override
    public float getFloat(String path) {
        return (float) section.getDouble(path);
    }

    @Override
    public float getFloat(String path, float def) {
        return (float) section.getDouble(path, def);
    }

    @Override
    public int getSecondsInTicks(String path) {
        return section.getInt(path, 0) * 20;
    }

    @Override
    public int getMinutesInTicks(String path) {
        return (section.getInt(path) * 60) * 20;
    }

    @Override
    public LocalDateTime getDate(String path) {
        return getDate(path, null);
    }

    @Override
    public LocalDateTime getDate(String path, LocalDateTime def) {
        try {
            return LocalDateTime.parse(getString(path));
        } catch (DateTimeParseException e) {
            return def;
        }
    }

    @Override
    public <E extends Enum<E>> E getEnum(String path, Class<E> enumClass) {
        return Utils.getEnum(enumClass, getString(path));
    }

    @Override
    public <E extends Enum<E>> E getEnum(String path, Class<E> enumClass, E def) {
        E value = Utils.getEnum(enumClass, getString(path));
        return value == null ? def : value;
    }

    @Override
    public <E extends Enum<E>> List<E> getEnumList(String path, Class<E> enumClass) {
        return null;
    }

    @Override
    public ItemStack getCustomItem(String path) {
//        return plugin.getItem(getString(path));
        return null;
    }

    @Override
    public Collection<ItemStack> getCustomItems(String path) {
//        return plugin.getItems(getStringList(path));
        return null;
    }

    @Override
    public Config getKeyOrSection(String path) {
        return isSubSection(path) ? getSubSection(path) : isSubKey(path) ? getSubKey(path) : null;
    }

    @Override
    public boolean isSubKey(String path) {
        return section.isSet(path);
    }

    @Override
    public ConfigKey getSubKey(String path) {
        return new ConfigKey(file, section, path);
    }

    @Override
    public Set<String> getKeysPath(String path, boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(path, deep)) {
            paths.add(pathOf(path, key));
        }

        return paths;
    }

    @Override
    public Set<String> getKeysAbsolutePath(String path, boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(path, deep)) {
            paths.add(pathOf(section.getCurrentPath(), path, key));
        }

        return paths;
    }

    @Override
    public <E extends Enum<E>> List<E> getEnumList(Class<E> enumClass, String path) {
        List<E> enumList = new ArrayList<>();

        for (String enumName : getStringList(path)) {
            E enumValue = Utils.getEnum(enumClass, enumName);
            if (enumValue == null) continue;

            enumList.add(enumValue);
        }

        return enumList;
    }

    @Override
    public List<ClickType> getClickList(String path) {
        return getEnumList(ClickType.class, path);
    }

    @Override
    public Material getMaterial(String path) {
        return getEnum(path, Material.class);
    }

    @Override
    public Material getMaterial(String path, Material def) {
        return getEnum(path, Material.class, def);
    }

    @Override
    public InventoryType getInventory(String path) {
        return getEnum(path, InventoryType.class);
    }

    @Override
    public InventoryType getInventory(String path, InventoryType def) {
        return getEnum(path, InventoryType.class, def);
    }

    @Override
    public BarColor getBarColor(String path) {
        return getEnum(path, BarColor.class);
    }

    @Override
    public BarColor getBarColor(String path, BarColor def) {
        return getEnum(path, BarColor.class, def);
    }

    @Override
    public BarStyle getBarStyle(String path) {
        return getEnum(path, BarStyle.class);
    }

    @Override
    public BarStyle getBarStyle(String path, BarStyle def) {
        return getEnum(path, BarStyle.class, def);
    }

    public Pair<String, String> getStringPair(String path) {
        return Pair.stringPairOf(getString(path));
    }

    public Pair<String, Integer> getStringIntPair(String path) {
        return Pair.stringIntPairOf(getString(path));
    }

    public List<Pair<String, String>> getStringPairList(String path) {
        List<Pair<String, String>> pairList = new ArrayList<>();

        for (String raw : getStringList(path)) {
            Pair<String, String> pair = Pair.stringPairOf(raw);

            if (pair != null) {
                pairList.add(pair);
            }
        }

        return pairList;
    }

    public List<Pair<String, Integer>> getStringIntPairList(String path) {
        List<Pair<String, Integer>> pairList = new ArrayList<>();

        for (String raw : getStringList(path)) {
            Pair<String, Integer> pair = Pair.stringIntPairOf(raw);

            if (pair != null) {
                pairList.add(pair);
            }
        }

        return pairList;
    }

    @Override
    public Set<String> getKeys(boolean deep) {
        return section.getKeys(deep);
    }

    @Override
    public Map<String, Object> getValues(boolean deep) {
        return section.getValues(deep);
    }

    @Override
    public boolean contains(String path) {
        return section.contains(path);
    }

    @Override
    public boolean contains(String path, boolean ignoreDefault) {
        return section.contains(path, ignoreDefault);
    }

    @Override
    public boolean isSet(String path) {
        return section.isSet(path);
    }

    @Override
    public String getCurrentPath() {
        return section.getCurrentPath();
    }

    @Override
    public String getName() {
        return file.getName().replace(".yml", "");
    }

    @Override
    public Configuration getRoot() {
        return section.getRoot();
    }

    @Override
    public ConfigurationSection getParent() {
        return section.getParent();
    }

    @Override
    public Object get(String path) {
        return section.get(path);
    }

    @Override
    public Object get(String path, Object def) {
        return section.get(path, def);
    }

    @Override
    public void set(String path, Object value) {
        section.set(path, value);
    }

    @Override
    public ConfigurationSection createSection(String path) {
        return section.createSection(path);
    }

    @Override
    public ConfigurationSection createSection(String path, Map<?, ?> map) {
        return section.createSection(path, map);
    }

    @Override
    public String getString(String path) {
        return getString(path, "");
    }

    @Override
    public String getString(String path, String def) {
        String s = section.getString(path);
        return s == null ? def : ChatColor.translateAlternateColorCodes('&', s);
    }

    @Override
    public boolean isString(String path) {
        return section.isString(path);
    }

    @Override
    public int getInt(String path) {
        return section.getInt(path);
    }

    @Override
    public int getInt(String path, int def) {
        return section.getInt(path, def);
    }

    @Override
    public boolean isInt(String path) {
        return section.isInt(path);
    }

    @Override
    public boolean getBoolean(String path) {
        return section.getBoolean(path);
    }

    @Override
    public boolean getBoolean(String path, boolean def) {
        return section.getBoolean(path, def);
    }

    @Override
    public boolean isBoolean(String path) {
        return section.isBoolean(path);
    }

    @Override
    public double getDouble(String path) {
        return section.getDouble(path);
    }

    @Override
    public double getDouble(String path, double def) {
        return section.getDouble(path, def);
    }

    @Override
    public boolean isDouble(String path) {
        return section.isDouble(path);
    }

    @Override
    public long getLong(String path) {
        return section.getLong(path);
    }

    @Override
    public long getLong(String path, long def) {
        return section.getLong(path, def);
    }

    @Override
    public boolean isLong(String path) {
        return section.isLong(path);
    }

    @Override
    public List<?> getList(String path) {
        return section.getList(path);
    }

    @Override
    public List<?> getList(String path, List<?> def) {
        return section.getList(path, def);
    }

    @Override
    public boolean isList(String path) {
        return section.isList(path);
    }

    @Override
    public List<String> getStringList(String path) {
        return section.getStringList(path);
    }

    @Override
    public List<Integer> getIntegerList(String path) {
        return section.getIntegerList(path);
    }

    @Override
    public List<Boolean> getBooleanList(String path) {
        return section.getBooleanList(path);
    }

    @Override
    public List<Double> getDoubleList(String path) {
        return section.getDoubleList(path);
    }

    @Override
    public List<Float> getFloatList(String path) {
        return section.getFloatList(path);
    }

    @Override
    public List<Long> getLongList(String path) {
        return section.getLongList(path);
    }

    @Override
    public List<Byte> getByteList(String path) {
        return section.getByteList(path);
    }

    @Override
    public List<Character> getCharacterList(String path) {
        return section.getCharacterList(path);
    }

    @Override
    public List<Short> getShortList(String path) {
        return section.getShortList(path);
    }

    @Override
    public List<Map<?, ?>> getMapList(String path) {
        return section.getMapList(path);
    }

    @Override
    public <T> T getObject(String path, Class<T> clazz) {
        return section.getObject(path, clazz);
    }

    @Override
    public <T> T getObject(String path, Class<T> clazz, T def) {
        return section.getObject(path, clazz, def);
    }

    @Override
    public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> clazz) {
        return section.getSerializable(path, clazz);
    }

    @Override
    public <T extends ConfigurationSerializable> T getSerializable(String path, Class<T> clazz, T def) {
        return section.getSerializable(path, clazz, def);
    }

    @Override
    public Vector getVector(String path) {
        return section.getVector(path);
    }

    @Override
    public Vector getVector(String path, Vector def) {
        return section.getVector(path, def);
    }

    @Override
    public boolean isVector(String path) {
        return section.isVector(path);
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String path) {
        return section.getOfflinePlayer(path);
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def) {
        return section.getOfflinePlayer(path, def);
    }

    @Override
    public boolean isOfflinePlayer(String path) {
        return section.isOfflinePlayer(path);
    }

    @Override
    public ItemStack getItemStack(String path) {
        if (isItemStack(path)) {
            return section.getItemStack(path);
        }
        return new ItemBuilder(getSubSection(path)).build();
    }

    @Override
    public ItemStack getItemStack(String path, ItemStack def) {
        if (isItemStack(path)) {
            return section.getItemStack(path, def);
        }
        return new ItemBuilder(getSubSection(path)).build();
    }

    @Override
    public boolean isItemStack(String path) {
        return section.isItemStack(path);
    }

    @Override
    public Color getColor(String path) {
        return section.getColor(path);
    }

    @Override
    public Color getColor(String path, Color def) {
        return section.getColor(path, def);
    }

    @Override
    public boolean isColor(String path) {
        return section.isColor(path);
    }

    @Override
    public Location getLocation(String path) {
        return getLocation(path, null);
    }

    @Override
    public Location getLocation(String path, Location def) {
        if (isSubSection(path)) return section.getLocation(path, def);

        if (isString(path)) {
            Location location = Deserialize.location(getString(path));
            if (location != null) return location;
        }

        return def;
    }

    @Override
    public boolean isLocation(String path) {
        return section.isLocation(path);
    }

    @Override
    public ConfigurationSection getConfigurationSection(String path) {
        return section.getConfigurationSection(path);
    }

    @Override
    public boolean isConfigurationSection(String path) {
        return section.isConfigurationSection(path);
    }

    @Override
    public ConfigurationSection getDefaultSection() {
        return section.getDefaultSection();
    }

    @Override
    public void addDefault(String path, Object value) {
        section.addDefault(path, value);
    }

    @Override
    public List<String> getComments(String path) {
        return section.getComments(path);
    }

    @Override
    public List<String> getInlineComments(String path) {
        return section.getInlineComments(path);
    }

    @Override
    public void setComments(String path, List<String> comments) {
        section.setComments(path, comments);
    }

    @Override
    public void setInlineComments(String path, List<String> comments) {
        section.setInlineComments(path, comments);
    }

    @Override
    public boolean isBoolean() {
        return false;
    }

    @Override
    public boolean isString() {
        return false;
    }

    @Override
    public boolean isInt() {
        return false;
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public boolean isFloat() {
        return false;
    }

    @Override
    public <T> boolean isListOf(Class<T> elementType) {
        return false;
    }

    @Override
    public boolean getBoolean() {
        return false;
    }

    @Override
    public String getString() {
        return "";
    }

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public double getDouble() {
        return 0;
    }

    @Override
    public float getFloat() {
        return 0;
    }

    @Override
    public List<String> getStringList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Integer> getIntegerList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Boolean> getBooleanList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Double> getDoubleList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Float> getFloatList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Long> getLongList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Byte> getByteList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Character> getCharacterList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<Short> getShortList() {
        return Collections.EMPTY_LIST;
    }


}