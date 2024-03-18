package me.pigauts.voxelmenus.util;

public record Flag(String name, int weight) {

    public Flag(String name) {
        this(name, 0);
    }

}
