package me.pigauts.voxelmenus.menu.meta;

import me.pigauts.voxelmenus.menu.widget.Icon;

public class AtlasMeta extends SimpleMeta {

    private final Icon[][] atlas;

    public AtlasMeta(String title, Icon[] buttons, MenuFunctions functions, Icon[][] atlas) {
        super(title, buttons, functions);
        this.atlas = atlas;
    }

    public Icon[][] getAtlas() {
        return atlas;
    }

}
