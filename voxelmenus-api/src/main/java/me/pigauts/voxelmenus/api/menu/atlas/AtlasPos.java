package me.pigauts.voxelmenus.api.menu.atlas;

import java.util.Objects;

public class AtlasPos {

    public static final AtlasPos ZERO_COORDS = new AtlasPos(0, 0);

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

    public void set(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public AtlasPos derive(int x, int y) {
        return new AtlasPos(this.x + x, this.y + y);
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

    @Override
    public AtlasPos clone() {
        return new AtlasPos(x, y);
    }

}
