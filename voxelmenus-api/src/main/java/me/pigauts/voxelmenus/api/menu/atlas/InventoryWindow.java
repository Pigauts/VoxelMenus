package me.pigauts.voxelmenus.api.menu.atlas;

public class InventoryWindow extends AtlasWindow {

    public InventoryWindow(AtlasPos origin, int length, int height) {
        super(origin, length, height);
    }

    public void setPosition(AtlasPos position) {
        setPosition(position.getX(), position.getY());
    }

    public void setPosition(int x, int y) {
        topLeftCorner.set(x, y);
        topLeftCorner.derive(0, height());
        topLeftCorner.derive(length(), 0);
        topLeftCorner.derive(length(), height());
    }

    public void translate(int x, int y) {
        topLeftCorner.translate(x, y);
        bottomLeftCorner.translate(x, y);
        topRightCorner.translate(x, y);
        bottomRightCorner.translate(x, y);
    }

    @Override
    public InventoryWindow clone() {
        return new InventoryWindow(topLeftCorner, length(), height());
    }

}
