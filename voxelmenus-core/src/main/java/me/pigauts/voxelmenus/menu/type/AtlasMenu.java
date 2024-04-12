package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.MenuType;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.menu.AtlasSettings;
import me.pigauts.voxelmenus.menu.view.AtlasMenuView;
import me.pigauts.voxelmenus.util.atlas.Atlas;
import me.pigauts.voxelmenus.util.atlas.InventoryWindow;

public class AtlasMenu extends StaticMenu {

    private final Atlas canvas;
    private final InventoryWindow window;

    public AtlasMenu(String name, AtlasSettings settings, InventoryMeta meta) {
        super(name, settings, meta);
        this.canvas = settings.getCanvas();
        this.window = settings.getWindow();
    }

    @Override
    public MenuType getType() {
        return MenuType.ATLAS;
    }

    public Atlas getCanvas() {
        return canvas.clone();
    }

    public InventoryWindow getWindow() {
        return window.clone();
    }

    @Override
    public <P extends MenuPlayer> MenuView createView(P player) {
        return new AtlasMenuView(this, player);
    }

}
