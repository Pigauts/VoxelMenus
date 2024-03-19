package me.pigauts.voxelmenus.core.config;

import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.holder.ValueHolder;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;
import java.util.List;

public class ConfigKey extends ConfigSection implements ValueHolder {

    private final String path;

    public ConfigKey(File file, ConfigurationSection section, String path) {
        super(file, section);
        Validate.notNull(path, "Path can't be null");
        this.path = path;
    }

    @Override
    public String getKey() {
        return path;
    }

    @Override
    public boolean isBoolean() {
        return super.isBoolean(path);
    }

    @Override
    public boolean isString() {
        return super.isString(path);
    }

    @Override
    public boolean isInt() {
        return super.isInt(path);
    }

    @Override
    public boolean isDouble() {
        return super.isDouble(path);
    }

    @Override
    public boolean isFloat() {
        return super.isDouble(path);
    }

    @Override
    public <T> boolean isListOf(Class<T> elementType) {
        if (!super.isList(path)) return false;

        List<?> list = super.getList(path);

        if (!list.isEmpty()) {
            Object firstElement = list.get(0);
            return elementType.isInstance(firstElement);
        }

        return false;
    }

    @Override
    public boolean getBoolean() {
        return super.getBoolean(path);
    }

    @Override
    public String getString() {
        return super.getString(path);
    }

    @Override
    public int getInt() {
        return super.getInt(path);
    }

    @Override
    public double getDouble() {
        return super.getDouble(path);
    }

    @Override
    public float getFloat() {
        return super.getFloat(path);
    }

    @Override
    public List<String> getStringList() {
        return super.getStringList(path);
    }

    @Override
    public List<Integer> getIntegerList() {
        return super.getIntegerList(path);
    }

    @Override
    public List<Boolean> getBooleanList() {
        return super.getBooleanList(path);
    }

    @Override
    public List<Double> getDoubleList() {
        return super.getDoubleList(path);
    }

    @Override
    public List<Float> getFloatList() {
        return super.getFloatList(path);
    }

    @Override
    public List<Long> getLongList() {
        return super.getLongList(path);
    }

    @Override
    public List<Byte> getByteList() {
        return super.getByteList(path);
    }

    @Override
    public List<Character> getCharacterList() {
        return super.getCharacterList(path);
    }

    @Override
    public List<Short> getShortList() {
        return super.getShortList(path);
    }
}
