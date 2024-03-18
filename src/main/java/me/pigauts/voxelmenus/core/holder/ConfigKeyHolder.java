package me.pigauts.voxelmenus.core.holder;

import me.pigauts.voxelmenus.core.config.Config;

import java.util.List;

public record ConfigKeyHolder(Config config, String key) implements ValueHolder {

    @Override
    public boolean isBoolean() {
        return config.isBoolean(key);
    }

    @Override
    public boolean isString() {
        return config.isString(key);
    }

    @Override
    public boolean isInt() {
        return config.isInt(key);
    }

    @Override
    public boolean isDouble() {
        return config.isDouble(key);
    }

    @Override
    public boolean isFloat() {
        return config.isFloat(key);
    }

    @Override
    public <T> boolean isListOf(Class<T> elementType) {
        if (!config.isList(key)) return false;

        List<?> list = config.getList(key);

        if (!list.isEmpty()) {
            Object firstElement = list.get(0);
            return elementType.isInstance(firstElement);
        }

        return false;
    }

    @Override
    public boolean getBoolean() {
        return config.getBoolean(key);
    }

    @Override
    public String getString() {
        return config.getNotNull(config::getString, key);
    }

    @Override
    public int getInt() {
        return config.getInt(key);
    }

    @Override
    public double getDouble() {
        return config.getDouble(key);
    }

    @Override
    public float getFloat() {
        return config.getFloat(key);
    }

    @Override
    public List<String> getStringList() {
        return config.getStringList(key);
    }

    @Override
    public List<Integer> getIntegerList() {
        return config.getIntegerList(key);
    }

    @Override
    public List<Boolean> getBooleanList() {
        return config.getBooleanList(key);
    }

    @Override
    public List<Double> getDoubleList() {
        return config.getDoubleList(key);
    }

    @Override
    public List<Float> getFloatList() {
        return config.getFloatList(key);
    }

    @Override
    public List<Long> getLongList() {
        return config.getLongList(key);
    }

    @Override
    public List<Byte> getByteList() {
        return config.getByteList(key);
    }

    @Override
    public List<Character> getCharacterList() {
        return config.getCharacterList(key);
    }

    @Override
    public List<Short> getShortList() {
        return config.getShortList(key);
    }
}
