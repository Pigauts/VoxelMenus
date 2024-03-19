package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.API.MenuType;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.view.AtlasMenuView;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.util.AtlasCanvas;
import me.pigauts.voxelmenus.util.AtlasPos;

public class AtlasMenu extends StaticMenu {

    private AtlasPos startingPosition;

    public AtlasMenu(String name, MenuSettings settings, MenuMeta meta) {
        super(name, settings, meta);
    }

    @Override
    public MenuType getType() {
        return MenuType.ATLAS;
    }

    public AtlasPos getStartingPosition() {
        return startingPosition;
    }

    public MenuMeta getMeta(AtlasPos pos) {

        AtlasCanvas window = new AtlasCanvas(1, 1, pos);

//        if (window.isWithout(layout.getCanvas())) {
//
//        }

        return null;
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new AtlasMenuView(this, player);
    }

}
