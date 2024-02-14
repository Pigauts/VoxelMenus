package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.view.EntireMenuView;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.event.inventory.InventoryType;

public class EntireMenu<M extends Menu> implements Menu {

    private final M topMenu;
    private final Icon[] contents;

    public EntireMenu(M topMenu, Icon[] contents) {
        this.topMenu = topMenu;
        this.contents = contents;
    }

    public String getName() {
        return topMenu.getName();
    }

    public InventoryType getStorage() {
        return topMenu.getStorage();
    }

    public int getSize() {
        return topMenu.getSize();
    }

    public int getRefresh() {
        return topMenu.getRefresh();
    }

    public boolean keepOpen() {
        return topMenu.keepOpen();
    }

    public boolean lockBottom() {
        return topMenu.lockBottom();
    }

    public boolean lockEmpty() {
        return topMenu.lockEmpty();
    }

    public M getTopMenu() {
        return topMenu;
    }

    public Icon[] getBottomContents() {
        return contents;
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new EntireMenuView(this, player);
    }

}
