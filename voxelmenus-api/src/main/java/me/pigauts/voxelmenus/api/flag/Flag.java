package me.pigauts.voxelmenus.api.flag;

public record Flag(String name, int weight) {

    public Flag(String name) {
        this(name, 0);
    }

}
