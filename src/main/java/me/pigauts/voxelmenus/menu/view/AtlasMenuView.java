package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.type.AtlasMenu;
import me.pigauts.voxelmenus.player.MenuPlayer;
import me.pigauts.voxelmenus.util.AtlasPos;

public class AtlasMenuView extends MetaMenuView<AtlasMenu, MenuPlayer> {

    private AtlasPos currentPosition;

    public AtlasMenuView(AtlasMenu menu, MenuPlayer player) {
        super(menu, player);
    }

    @Override
    public MenuMeta getMenuMeta() {
        return menu.getMeta(currentPosition);
    }

    public AtlasPos getAtlasPosition() {
        return currentPosition;
    }

    public void setAtlasPosition(AtlasPos position) {
        this.currentPosition = position;
        onUpdate();
    }

    public void translate(int x, int y) {
        currentPosition.translate(x, y);
        onUpdate();
    }

}
