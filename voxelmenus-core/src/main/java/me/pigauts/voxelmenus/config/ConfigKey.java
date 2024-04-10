package me.pigauts.voxelmenus.config;

import me.pigauts.voxelmenus.api.config.ValueHolder;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;
import java.util.List;

public class ConfigKey extends ConfigSection implements ValueHolder {

    private final String key;

    public ConfigKey(File file, ConfigurationSection section, String key) {
        super(file, section);
        Validate.notNull(key, "Path can't be null");
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public boolean isBoolean() {
        return super.isBoolean(key);
    }

    @Override
    public boolean isString() {
        return super.isString(key);
    }

    @Override
    public boolean isInt() {
        return super.isInt(key);
    }

    @Override
    public boolean isDouble() {
        return super.isDouble(key);
    }

    @Override
    public boolean isFloat() {
        return super.isDouble(key);
    }

    @Override
    public <T> boolean isListOf(Class<T> elementType) {
        if (!super.isList(key)) return false;

        List<?> list = super.getList(key);

        if (!list.isEmpty()) {
            Object firstElement = list.get(0);
            return elementType.isInstance(firstElement);
        }

        return false;
    }

    @Override
    public boolean getBoolean() {
        return super.getBoolean(key);
    }

    @Override
    public String getString() {
        return super.getString(key);
    }

    @Override
    public int getInt() {
        return super.getInt(key);
    }

    @Override
    public double getDouble() {
        return super.getDouble(key);
    }

    @Override
    public float getFloat() {
        return super.getFloat(key);
    }

    @Override
    public List<String> getStringList() {
        return super.getStringList(key);
    }

    @Override
    public List<Integer> getIntegerList() {
        return super.getIntegerList(key);
    }

    @Override
    public List<Boolean> getBooleanList() {
        return super.getBooleanList(key);
    }

    @Override
    public List<Double> getDoubleList() {
        return super.getDoubleList(key);
    }

    @Override
    public List<Float> getFloatList() {
        return super.getFloatList(key);
    }

    @Override
    public List<Long> getLongList() {
        return super.getLongList(key);
    }

    @Override
    public List<Byte> getByteList() {
        return super.getByteList(key);
    }

    @Override
    public List<Character> getCharacterList() {
        return super.getCharacterList(key);
    }

    @Override
    public List<Short> getShortList() {
        return super.getShortList(key);
    }
}
