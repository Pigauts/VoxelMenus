package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.Menu;

public abstract class SimpleMenu implements Menu {

    private final String name;
    private final String title;
    private final int size;
    private final int refresh;
    private final Function openFunction, closeFunction;

    public SimpleMenu(String name, String title, int size, int refreshTicks, Function openFunction, Function closeFunction) {
        this.name = name;
        this.title = title;
        this.size = size;
        this.refresh = refreshTicks;
        this.openFunction = openFunction;
        this.closeFunction = closeFunction;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public int getRefresh() {
        return refresh;
    }

    public Function getOpenFunction() {
        return openFunction;
    }

    public Function getCloseFunction() {
        return closeFunction;
    }

}
