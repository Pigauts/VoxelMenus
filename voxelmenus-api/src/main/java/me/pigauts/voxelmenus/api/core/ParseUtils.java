package me.pigauts.voxelmenus.api.core;

import java.util.Arrays;
import java.util.List;

public class ParseUtils {

    public static int parseInteger(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean parseBoolean(String text) {
        return Boolean.parseBoolean(text);
    }

    public static List<String> parseStringList(String text) {
        return Arrays.asList(text.split(","));
    }

}
