package me.pigauts.voxelmenus.menu;

public class MenuSettings {

    private final int refresh;
    private final boolean keepOpen;
    private final boolean lockBottom;
    private final boolean lockEmpty;

    public MenuSettings(int refresh, boolean keepOpen, boolean lockBottom, boolean lockEmpty) {
        this.refresh = refresh;
        this.keepOpen = keepOpen;
        this.lockBottom = lockBottom;
        this.lockEmpty = lockEmpty;
    }

    public int getRefresh() {
        return refresh;
    }

    public boolean isKeepOpen() {
        return keepOpen;
    }

    public boolean isLockBottom() {
        return lockBottom;
    }

    public boolean isLockEmpty() {
        return lockEmpty;
    }

}
