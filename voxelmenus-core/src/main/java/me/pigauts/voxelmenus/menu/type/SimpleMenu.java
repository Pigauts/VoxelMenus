package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.menu.MenuSettings;

public abstract class SimpleMenu implements Menu {

    protected final String name;
    protected final int refresh;
    protected final boolean keepOpen;
    protected final boolean lockBottom, lockEmpty;

    public SimpleMenu(String name, MenuSettings settings) {
        this.name = name;
        this.refresh = settings.getRefresh();
        this.keepOpen = settings.isKeepOpen();
        this.lockBottom = settings.isLockBottom();
        this.lockEmpty = settings.isLockEmpty();
    }

    @Override
    public MenuType getType() {
        return MenuType.SIMPLE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRefresh() {
        return refresh;
    }

    @Override
    public boolean keepOpen() {
        return keepOpen;
    }

    @Override
    public boolean lockBottom() {
        return lockBottom;
    }

    @Override
    public boolean lockEmpty() {
        return lockEmpty;
    }

}
