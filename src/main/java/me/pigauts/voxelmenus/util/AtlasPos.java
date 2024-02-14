package me.pigauts.voxelmenus.util;

import java.util.Objects;

public class AtlasPos {

    private int x;
    private int y;

    public AtlasPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        AtlasPos atlasPos = (AtlasPos) obj;
        return x == atlasPos.x && y == atlasPos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
