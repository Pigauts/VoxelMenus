package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.menu.widget.Icon;

public class Atlas {

    private final AtlasCanvas canvas;
    private final Icon[] icons;

    public Atlas(AtlasCanvas canvas, Icon[] icons) {
        this.canvas = canvas;
        this.icons = icons;
    }

    public AtlasCanvas getCanvas() {
        return canvas;
    }

    public Icon[] getIcons() {
        return icons;
    }
}
