package me.pigauts.voxelmenus.util;

public record Pair<K, V>(K key, V value) {

    public static Pair<String, String> stringPairOf(String raw) {
        String[] split = raw.split(":");
        if (split.length != 2) return null;

        return new Pair<>(split[0], split[1]);
    }

    public static Pair<String, Integer> stringIntPairOf(String raw) {
        String[] split = raw.split(":");
        if (split.length != 2 || !Utils.isNumber(split[1])) return null;

        return new Pair<>(split[0], Utils.parseInt(split[1]));
    }

}
