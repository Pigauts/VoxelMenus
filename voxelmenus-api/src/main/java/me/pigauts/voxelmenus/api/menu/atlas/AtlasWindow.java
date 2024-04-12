package me.pigauts.voxelmenus.api.menu.atlas;

public class AtlasWindow {

    private final int length, height;

    protected final /* @Origin */ AtlasPos topLeftCorner;
    protected final AtlasPos bottomLeftCorner;
    protected final AtlasPos topRightCorner;
    protected final AtlasPos bottomRightCorner;

    public AtlasWindow(int length, int height) {
        this(AtlasPos.ZERO_COORDS, length, height);
    }

    public AtlasWindow(AtlasPos origin, int length, int height) {
        this(origin, origin.derive(0, height), origin.derive(length, 0),
                origin.derive(length, height), length, height);
    }

    public AtlasWindow(AtlasPos topLeftCorner, AtlasPos bottomLeftCorner, AtlasPos topRightCorner, AtlasPos bottomRightCorner, int length, int height) {
        this.topLeftCorner = topLeftCorner;
        this.bottomLeftCorner = bottomLeftCorner;
        this.topRightCorner = topRightCorner;
        this.bottomRightCorner = bottomRightCorner;
        this.length = length;
        this.height = height;
    }

    private boolean contains(AtlasPos pos) {
        return pos.getX() >= topLeftCorner.getX() && pos.getX() <= topRightCorner.getX() &&
                pos.getY() >= topLeftCorner.getY() && pos.getY() <= bottomLeftCorner.getY();
    }

    public boolean isWithin(AtlasWindow window) {
        return window.contains(topLeftCorner) && window.contains(bottomLeftCorner) &&
                window.contains(topRightCorner) && window.contains(bottomRightCorner);
    }

    public boolean isWithin(AtlasPos pos) {
        return contains(pos);
    }

    public int length() {
        return length;
    }

    public int height() {
        return height;
    }

    public AtlasPos getPosition(int index) {
        if (index < 0 || index >= size()) return null;
        return topLeftCorner.derive(index / length, index % length);
    }

    public int size() {
        return length * height;
    }

    public AtlasPos topLeftCorner() {
        return topLeftCorner.clone();
    }

    public AtlasPos bottomLeftCorner() {
        return bottomLeftCorner.clone();
    }

    public AtlasPos topRightCorner() {
        return topRightCorner.clone();
    }

    public AtlasPos bottomRightCorner() {
        return bottomRightCorner.clone();
    }

    @Override
    public AtlasWindow clone() {
        return new AtlasWindow(topLeftCorner.clone(), bottomLeftCorner.clone(), topRightCorner.clone(), bottomRightCorner.clone(), length, height);
    }

}
