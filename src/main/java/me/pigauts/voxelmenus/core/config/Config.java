package me.pigauts.voxelmenus.core.config;

import me.pigauts.voxelmenus.API.MenusPlugin;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.animation.Animation;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.factory.ConfigKeyFactory;
import me.pigauts.voxelmenus.core.factory.Factory;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.core.holder.ConfigKeyHolder;
import me.pigauts.voxelmenus.item.ItemBuilder;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.message.Message;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.util.Deserialize;
import me.pigauts.voxelmenus.util.Pair;
import me.pigauts.voxelmenus.util.Path;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class Config implements ConfigurationSection {

    private static final MenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    protected final File file;
    protected final ConfigurationSection section;

    public Config(File file) {
        this(file, YamlConfiguration.loadConfiguration(file));
    }

    public Config(File file, ConfigurationSection section) {
        Validate.notNull(file, "File can't be null");
        Validate.notNull(section, "Configuration section can't be null");
        this.file = file;
        this.section = section;
    }

    protected String pathOf(String... args) {
        return Path.of(args);
    }

    @NotNull
    @Override
    public String getName() {
        return file.getName().replace(".yml", "");
    }

    @NotNull
    public String getFileName() {
        return file.getName();
    }

    @NotNull
    public File getFile() {
        return file;
    }

    public void createFile() {
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public void save() {
        if (!file.exists()) createFile();
        if (!(section instanceof YamlConfiguration yamlConfig)) return;
        try {
            yamlConfig.save(file);
        } catch (IOException e) {
        }
    }

    protected String getAbsolutePath(String... keys) {
        return Path.at(section.getCurrentPath(), keys);
    }

    public void validate(boolean condition, String path, String error) throws ConfigurationException {
        if (condition) return;
        throw new ConfigurationException(String.format("Mistake found in file '%s' at key '%s': %s", file.getPath(), getAbsolutePath(path), error));
    }

    @NotNull
    public <T> T validate(T notNull, String... keys) throws ConfigurationException {
        if (isSet(keys) && notNull != null) return notNull;
        throw new ConfigurationException(String.format("Mistake found in file '%s' at key '%s': %s", file.getPath(), getAbsolutePath(keys), "Value is not set or invalid"));
    }

    @Nullable
    public <R> R get(Factory<String, R> factory, String... keys) {
        return factory.create(Path.of(keys));
    }

    @NotNull
    public <R> R getNotNull(Factory<String, R> factory, String... keys) throws ConfigurationException {
        return validate(get(factory, keys), keys);
    }

    @Nullable
    public <R> R getAtSection(ConfigFactory<R> factory, String... keys) {
        return factory.create(getSection(keys));
    }

    @NotNull
    public <R> R getNotNullAtSection(ConfigFactory<R> factory, String... keys) throws ConfigurationException {
        return validate(getAtSection(factory, keys), keys);
    }

    @Nullable
    public <R> R getAtKey(ConfigKeyFactory<R> factory, String... keys) {
        return factory.create(this, Path.of(keys));
    }

    @NotNull
    public <R> R getNotNullAtKey(ConfigKeyFactory<R> factory, String... keys) throws ConfigurationException {
        return validate(getAtKey(factory, keys), keys);
    }

//    protected <T> T notNull(T obj, String key) throws ConfigurationException {
//        if (obj != null) return obj;
//        throw new ConfigurationException(String.format("Mistake found in file '%s' at key '%s': %s", file.getPath(), getAbsolutePath(key), "Value is not set or invalid"));
//    }

    public World getWorld(String path) {
        World world = Bukkit.getWorld(getString(path));
        return world == null ? plugin.getWorld() : world;
    }

    public MenuPlayer getMenuPlayer(String path) {
        return plugin.getPlayer(getUUID(path));
    }

    public Menu getCustomMenu(String path) {
        return plugin.getMenu(getString(path));
    }

    public ItemStack getCustomItem(String path) {
        return plugin.getItem(getString(path));
    }

    public Collection<ItemStack> getCustomItems(String path) {
        return plugin.getItems(getStringList(path));
    }

    public Animation getCustomAnimation(String path) {
        return plugin.getAnimation(getString(path));
    }

    public Message getCustomMessage(String path) {
        return plugin.getMessage(getString(path));
    }

    public FunctionSet getCustomFunction(String path) {
        return plugin.getCustomFunction(getString(path));
    }

    public Button getCustomIcon(String path) {
        return plugin.getCustomButton(getString(path));
    }

    public boolean isSection(String... paths) {
        for (String path : paths) {
            if (!section.isConfigurationSection(path)) return false;
        }
        return true;
    }

    public Set<String> getKeys(String path, boolean deep) {
        if (!isSection(path)) return Collections.EMPTY_SET;
        return section.getConfigurationSection(path).getKeys(deep);
    }

    public ConfigKeyHolder getKeyHolder(String path, String key) {
        Config section = getSection(path);
        if (section == null || !section.isSet(key)) return null;
        return new ConfigKeyHolder(section, key);
    }

    @Nullable
    public Config getSection(String... keys) {
        return getSection(Path.of(keys));
    }

    @Nullable
    public Config getSection(String path) {
        return isSection(path) ? new Config(file, getConfigurationSection(path)) : null;
    }

    public List<Config> getSections() {
        List<Config> sections = new ArrayList<>();

        for (String key : getKeys(false)) {
            Config section = getSection(key);

            if (section != null) {
                sections.add(section);
            }
        }

        return sections;
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
            paths.add(Util.buildPath(path, key));
        }

        return paths;
    }

    public Set<String> getKeysAbsolutePath(boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(deep)) {
            paths.add(Util.buildPath(section.getCurrentPath(), key));
        }

        return paths;
    }

    public Set<String> getKeysAbsolutePath(String path, boolean deep) {
        Set<String> paths = new HashSet<>();

        for (String key : getKeys(path, deep)) {
            paths.add(Util.buildPath(section.getCurrentPath(), path, key));
        }

        return paths;
    }

    @NotNull
    public String getColorString(String path) {
        return ChatColor.translateAlternateColorCodes('&', getString(path));
    }

    @NotNull
    public String getColorString(String path, String defaultValue) {
        return ChatColor.translateAlternateColorCodes('&', getString(path));
    }

    @NotNull
    public int getSecondsInTicks(String path) {
        return section.getInt(path, 0) * 20;
    }

    @NotNull
    public int getMinutesInTicks(String path) {
        return (section.getInt(path, 0) * 60) * 20;
    }

    @NotNull
    public LocalDateTime getDate(String path) {
        return LocalDateTime.parse(getString(path));
    }

    public <E extends Enum<E>> E getEnum(String path, Class<E> enumClass) {
        return Util.getEnum(enumClass, getString(path));
    }

    @NotNull
    public <E extends Enum<E>> E getEnum(String path, Class<E> enumClass, E def) {
        E value = Util.getEnum(enumClass, getString(path));
        return value == null ? def : value;
    }

    public <E extends Enum<E>> List<E> getEnumList(Class<E> enumClass, String path) {
        List<E> enumList = new ArrayList<>();

        for (String enumName : getStringList(path)) {
            E enumValue = Util.getEnum(enumClass, enumName);
            if (enumValue == null) continue;

            enumList.add(enumValue);
        }

        return enumList;
    }

    public List<ClickType> getClickList(String path) {
        return getEnumList(ClickType.class, path);
    }

    public Material getMaterial(String path) {
        return getEnum(path, Material.class);
    }

    @NotNull
    public Material getMaterial(String path, Material def) {
        return getEnum(path, Material.class, def);
    }

    public InventoryType getInventory(String path) {
        return getEnum(path, InventoryType.class);
    }

    @NotNull
    public InventoryType getInventory(String path, InventoryType def) {
        return getEnum(path, InventoryType.class, def);
    }

    public BarColor getBarColor(String path) {
        return getEnum(path, BarColor.class);
    }

    @NotNull
    public BarColor getBarColor(String path, BarColor def) {
        return getEnum(path, BarColor.class, def);
    }

    public BarStyle getBarStyle(String path) {
        return getEnum(path, BarStyle.class);
    }

    @NotNull
    public BarStyle getBarStyle(String path, BarStyle def) {
        return getEnum(path, BarStyle.class, def);
    }


    public UUID getUUID(String path) {
        return Util.getUUID(getString(path));
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

    public boolean isSet(String... keys) {
        return section.isSet(Path.of(keys));
    }

    @Override
    public String getCurrentPath() {
        return section.getCurrentPath();
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

    public char getChar(String path) {
        return getChar(path, '0');
    }

    public char getChar(String path, char def) {
        String string = getString(path);
        return string.isEmpty() ? def : string.charAt(0);
    }

    @Override
    public String getString(String path) {
        return section.getString(path);
    }

    @Override
    public String getString(String path, String def) {
        return section.getString(path, def);
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

    public float getFloat(String path) {
        return (float) section.getDouble(path);
    }

    public float getFloat(String path, float def) {
        return (float) section.getDouble(path, def);
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
        return new ItemBuilder(getSection(path)).build();
    }

    @Override
    public ItemStack getItemStack(String path, ItemStack def) {
        if (isItemStack(path)) {
            return section.getItemStack(path, def);
        }
        return new ItemBuilder(getSection(path)).build();
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
        if (isSection(path)) return section.getLocation(path, def);

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

    @Nullable
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
    public Set<String> getKeys(boolean deep) {
        return section.getKeys(deep);
    }

    public boolean isFloat(String key) {
        return isDouble(key);
    }

}