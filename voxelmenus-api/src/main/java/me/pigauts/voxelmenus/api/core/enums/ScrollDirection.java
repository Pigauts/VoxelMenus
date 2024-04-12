package me.pigauts.voxelmenus.api.core.enums;

public enum ScrollDirection {

    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),

    RIGHT_UP(1, 1),
    RIGHT_DOWN(1, -1),
    LEFT_UP(-1, 1),
    LEFT_DOWN(-1, -1);

    private final int x, y;

    ScrollDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX(int amount) {
        int x1;
        return x == 0 ? 0 : x < 0 ? x - amount : x + amount;
    }

    public int getY(int amount) {
        return y;
    }

}
