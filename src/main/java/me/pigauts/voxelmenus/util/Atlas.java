package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.menu.widget.Button;

public class Atlas {

    private final AtlasCanvas canvas;
    private final Button[] icons;

    public Atlas(AtlasCanvas canvas, Button[] icons) {
        this.canvas = canvas;
        this.icons = icons;
    }

    public AtlasCanvas getCanvas() {
        return canvas;
    }

    public Button[] getIcons() {
        return icons;
    }
}
