package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.menu.view.SimpleView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.event.inventory.InventoryType;

public class SimpleMenu implements Menu {

    protected final String name;
    protected final InventoryType storage;
    protected final int size;
    protected final int refresh;
    protected final boolean keepOpen;
    protected final boolean lockBottom, lockEmpty;

    public SimpleMenu(String name, MenuSettings settings) {
        this.name = name;
        this.storage = settings.storage();
        this.size = settings.size();
        this.refresh = settings.refresh();
        this.keepOpen = settings.keepOpen();
        this.lockBottom = settings.lockBottom();
        this.lockEmpty = settings.lockEmpty();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public InventoryType getStorage() { return storage; }

    @Override
    public int getSize() {
        return size;
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

    @Override
    public MenuView createView(MenuPlayer player) {
        return new SimpleView(this, player);
    }

}
