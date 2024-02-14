package me.pigauts.voxelmenus.util;

public class AtlasCanvas {

    private final AtlasPos topLeft;
    private final AtlasPos bottomLeft;
    private final AtlasPos topRight;
    private final AtlasPos bottomRight;

    public AtlasCanvas(int length, int height) {
        this.topLeft = new AtlasPos(0, 0);
        this.bottomLeft = new AtlasPos(0, height);
        this.topRight = new AtlasPos(length, 0);
        this.bottomRight = new AtlasPos(length, height);
    }

    public AtlasCanvas(int length, int height, AtlasPos pos) {
        this.topLeft = new AtlasPos(pos.getX(), pos.getY());
        this.bottomLeft = new AtlasPos(pos.getX(), pos.getY() + height);
        this.topRight = new AtlasPos(pos.getX() + length, pos.getX());
        this.bottomRight = new AtlasPos(pos.getX() + length, pos.getY() + height);
    }

    public boolean isWithin(AtlasCanvas canvas) {
        return canvas.contains(topLeft) && canvas.contains(bottomLeft) &&
                canvas.contains(topRight) && canvas.contains(bottomRight);
    }

    public boolean isWithout(AtlasCanvas canvas) {
        return contains(canvas.topLeft()) && contains(canvas.bottomLeft()) &&
                contains(canvas.topRight()) && contains(canvas.bottomRight());
    }

    private boolean contains(AtlasPos pos) {
        return pos.getX() >= topLeft.getX() && pos.getX() <= topRight.getX() &&
                pos.getY() >= topLeft.getY() && pos.getY() <= bottomLeft.getY();
    }

    public AtlasPos topLeft() {
        return topLeft;
    }

    public AtlasPos bottomLeft() {
        return bottomLeft;
    }

    public AtlasPos topRight() {
        return topRight;
    }

    public AtlasPos bottomRight() {
        return bottomRight;
    }

}
