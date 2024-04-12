package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.view.EntireMenuView;
import org.bukkit.event.inventory.InventoryType;

public class EntireMenu<M extends Menu> implements Menu {

    private final M topMenu;
    private final TemplateButton[] contents;

    public EntireMenu(M topMenu, TemplateButton[] contents) {
        this.topMenu = topMenu;
        this.contents = contents;
    }

    @Override
    public MenuType getType() {
        return topMenu.getType();
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

    public Button[] getBottomContents() {
        return contents;
    }

    @Override
    public <P extends MenuPlayer> MenuView createView(P player) {
        return new EntireMenuView(this, player);
    }

}
