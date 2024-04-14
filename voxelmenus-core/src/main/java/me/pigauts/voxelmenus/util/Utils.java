package me.pigauts.voxelmenus.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Utils {

    private Utils() {}

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

    public static boolean isUUID(String s) {
        try {
            UUID.fromString(s);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static UUID getUUID(String s) {
        try {
            return UUID.fromString(s);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static <E extends Enum<E>> boolean isEnum(Class<E> enumClass, String enumName) {
        try {
            Enum.valueOf(enumClass, enumName.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName) {
        try {
            return Enum.valueOf(enumClass, enumName.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static boolean isNumber(String s) {
        return parseInt(s) != null;
    }

    public static Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
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

    public static <T> T[] toNotNullArray(Collection<T> collection, T[] array) {
        if (collection == null) return array;
        collection.removeIf(Objects::isNull);
        return collection.toArray(array);
    }

    public static <T> T[] toNotNullArray(@NotNull T[] array) {
        return Arrays.stream(array)
                .filter(element -> element != null)
                .toArray(size -> Arrays.copyOf(array, size));
    }

    public static int[] toIntArray(Collection<Integer> integerCollection) {
        int[] intArray = new int[integerCollection.size()];

        int i = 0;
        for (Integer num : integerCollection) {
            intArray[i++] = num;
        }

        return intArray;
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

    public static <T> T nonNullOrElse(@Nullable T nullable, @NotNull T def) {
        return nullable != null ? nullable : def;
    }

    public static <T, R> R getOrElseNull(Function<T, R> function, @Nullable T t) {
        return t != null ? function.apply(t) : null;
    }

    public static <T> T getOrElseNull(@Nullable Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static <R> void forLoop(Consumer<Integer> consumer, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            consumer.accept(i);
        }
    }

    public static <T> boolean isEqual(T obj, T... cases) {
        for (T c : cases) {
            if (obj.equals(c)) return true;
        }
        return false;
    }

    public static <T> T executeIfNonNull(T t, Consumer<T> consumer) {
        if (t != null) consumer.accept(t);
        return t;
    }

    public static String getStringSplitAt(String s, String regex, int index) {
        String[] split = s.split(regex);
        return index > 0 && index < split.length ? split[index] : null;
    }

    public static String pathOf(String... keys) {
        return String.join(".", keys);
    }

//    public void update(Player p, String title){
//        EntityPlayer ep = ((CraftPlayer)p).getHandle();
//        IChatBaseComponent invTitle = new ChatMessage(title);
//        PacketPlayOutOpenWindow packet = new PacketPlayOutOpenWindow(ep.activeContainer.windowId, Containers.GENERIC_9X6, invTitle);
//        ep.playerConnection.sendPacket(packet);
//        ep.updateInventory(ep.activeContainer);
//    }

}
