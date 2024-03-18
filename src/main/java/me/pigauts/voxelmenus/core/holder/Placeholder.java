package me.pigauts.voxelmenus.core.holder;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record Placeholder(String id, Object value) implements ValueHolder {

    public static final Placeholder EMPTY = new Placeholder("", "");

    @NotNull
    public static Placeholder of(String id, Object value) {
        if (id == null || value == null) return EMPTY;
        return new Placeholder(id, value);
    }

    public String apply(String s) {
        return s.replaceAll(id, value.toString());
    }

    public ItemMeta apply(ItemMeta meta) {
        if (meta != null) {
            meta.setDisplayName(apply(meta.getDisplayName()));

            List<String> lore = meta.getLore();
            for (int i = 0; i < lore.size(); i++) {
                lore.set(i, apply(lore.get(i)));
            }
            meta.setLore(lore);
        }

        return meta;
    }

    public ItemStack apply(ItemStack item) {
        item.setItemMeta(apply(item.getItemMeta()));
        return item;
    }

    @Override
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    @Override
    public boolean isString() {
        return value instanceof String;
    }

    @Override
    public boolean isInt() {
        return value instanceof Integer;
    }

    @Override
    public boolean isDouble() {
        return value instanceof Double;
    }

    @Override
    public boolean isFloat() {
        return value instanceof Float;
    }

    public <T> boolean isListOf(Class<T> elementType) {
        if (value instanceof List<?>) {
            List<?> list = (List<?>) value;
            if (!list.isEmpty()) {
                Object firstElement = list.get(0);
                return elementType.isInstance(firstElement);
            }
        }
        return false;
    }

    @Override
    public boolean getBoolean() {
        return (boolean) value;
    }

    @Override
    public String getString() {
        return String.valueOf(value);
    }

    @Override
    public int getInt() {
        return (int) value;
    }

    @Override
    public double getDouble() {
        return (double) value;
    }

    @Override
    public float getFloat() {
        return (float) value;
    }

    @Override
    public List<String> getStringList() {
        return (List<String>) value;
    }

    @Override
    public List<Integer> getIntegerList() {
        return (List<Integer>) value;
    }

    @Override
    public List<Boolean> getBooleanList() {
        return (List<Boolean>) value;
    }

    @Override
    public List<Double> getDoubleList() {
        return (List<Double>) value;
    }

    @Override
    public List<Float> getFloatList() {
        return (List<Float>) value;
    }

    @Override
    public List<Long> getLongList() {
        return (List<Long>) value;
    }

    @Override
    public List<Byte> getByteList() {
        return (List<Byte>) value;
    }

    @Override
    public List<Character> getCharacterList() {
        return (List<Character>) value;
    }

    @Override
    public List<Short> getShortList() {
        return (List<Short>) value;
    }

}
