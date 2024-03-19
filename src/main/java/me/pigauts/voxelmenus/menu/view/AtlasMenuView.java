package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.AtlasScroll;
import me.pigauts.voxelmenus.API.MenuAction;
import me.pigauts.voxelmenus.API.menu.view.AtlasView;
import me.pigauts.voxelmenus.menu.type.AtlasMenu;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.util.AtlasPos;

public class AtlasMenuView<T extends AtlasMenu, P extends MenuPlayer> extends MetaMenuView implements AtlasView {

    private AtlasPos currentPosition;

    public AtlasMenuView(T menu, P player) {
        super(menu, player);
    }

    public AtlasPos getAtlasPosition() {
        return currentPosition;
    }

    public void setAtlasPosition(AtlasPos position) {
        this.currentPosition = position;
        update();
        player.executeFunction(meta.getFunction(MenuAction.ATLAS_SCROLL));
    }

    public void scroll(int x, int y) {
        currentPosition.translate(x, y);
        update();
        player.executeFunction(meta.getFunction(MenuAction.ATLAS_SCROLL));
    }

    @Override
    public void scroll(AtlasScroll direction) {
        scroll(direction.getX(), direction.getY());
    }

    @Override
    public void scroll(AtlasScroll direction, int amount) {
        int x, y;
        scroll((x = direction.getX()) == 0 ? x : x * amount, (y = direction.getY()) == 0 ? y : y * amount);
    }

    @Override
    public AtlasPos getPosition() {
        return currentPosition;
    }

    @Override
    public void setPosition(AtlasPos position) {
        this.currentPosition = position;
    }



}
