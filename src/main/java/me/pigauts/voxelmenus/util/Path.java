package me.pigauts.voxelmenus.util;

import java.io.File;
import java.util.StringJoiner;

public class Path {

    public static String at(String path, String... args) {
        StringJoiner joiner = new StringJoiner(File.separator);
        joiner.add(path);

        for (String arg : args) {
            if (arg == null || arg.isEmpty()) continue;
            joiner.add(arg);
        }

        return joiner.toString();
    }

    public static String of(String... args) {
        StringJoiner joiner = new StringJoiner(File.separator);

        for (String arg : args) {
            if (arg == null || arg.isEmpty()) continue;
            joiner.add(arg);
        }

        return joiner.toString();
    }

}
