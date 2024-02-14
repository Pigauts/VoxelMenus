package me.pigauts.voxelmenus.menu.meta;

import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.widget.Icon;

public class SimpleMeta implements MenuMeta {

    private final String title;
    private final Icon[] icons;
    private final Function openFunction, closeFunction, updateFunction;

    public SimpleMeta(String title, Icon[] icons, MenuFunctions functions) {
        this.title = title;
        this.icons = icons;
        this.openFunction = functions.openFunction();
        this.closeFunction = functions.closeFunction();
        this.updateFunction = functions.updateFunction();
    }

    public String getTitle() {
        return title;
    }

    public Icon[] getIcons() {
        return icons;
    }

    public Function getOpenFunction() {
        return openFunction;
    }

    public Function getCloseFunction() {
        return closeFunction;
    }

    public Function getUpdateFunction() {
        return updateFunction;
    }

}

