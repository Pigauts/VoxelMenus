package me.pigauts.voxelmenus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;

public abstract class Helper {

    public static final List<String> NULL_CHARACTERS = Arrays.asList("_", "n", "null");

    public static void callEvent(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

    public static boolean isPluginEnabled(String name) {
        return Bukkit.getPluginManager().isPluginEnabled(name);
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String enumFormat(String s) {
        return s.toUpperCase().replace(" ", "_");
    }

    public static <E extends Enum<E>> boolean isValidEnum(Class<E> enumClass, String enumName) {
        try {
            Enum.valueOf(enumClass, enumName);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName) {
        if (!isValidEnum(enumClass, enumName)) return null;
        return Enum.valueOf(enumClass, enumName);
    }

    public static boolean isNumber(String s) {
        return getNumber(s) != null;
    }

    public static Integer getNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String buildPath(String... args) {
        StringJoiner joiner = new StringJoiner(File.separator);

        for (String arg : args) {
            if (arg == null || arg.isEmpty()) continue;
            joiner.add(arg);
        }

        return joiner.toString();
    }

    public static boolean isOnline(String playerName) {
        return Bukkit.getPlayer(playerName) != null;
    }

    public static String[] getSubArray(String[] original, int start, int end) {
        int length = end - start + 1;
        String[] subArray = new String[length];

        for (int i = 0; i < length; i++) {
            int index = start + i;
            subArray[i] = index < original.length ? original[index] : "";
        }

        return subArray;
    }

    public static <K, V> V getContainingString(Map<K, V> map, String searchString) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey().toString().contains(searchString)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static <T> Set<Integer> findAllIndexes(List<T> list, T element) {
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i).equals(element))
                .collect(HashSet::new, Set::add, Set::addAll);
    }

    public static <T> T cast(Object object, Class<T> clazz) {
        return clazz.isAssignableFrom(object.getClass()) ? (T) object : null;
    }

    public static <T> T[] toArray(Collection<T> collection) {
        collection.removeIf(Objects::isNull);
        return (T[]) collection.toArray(new Object[collection.size()]);
    }


    public static String stringOf(String... strings) {
        StringBuilder builder = new StringBuilder();

        for (String s : strings) builder.append(s);

        return builder.toString();
    }

    public static boolean intArrayContains(int[] array, int num) {
        for (int i : array) {
            if (i == num) return true;
        }
        return false;
    }



}
