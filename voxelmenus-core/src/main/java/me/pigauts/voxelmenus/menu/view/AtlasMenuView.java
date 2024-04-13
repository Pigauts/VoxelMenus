package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.core.enums.MenuFunction;
import me.pigauts.voxelmenus.api.core.enums.ScrollDirection;
import me.pigauts.voxelmenus.api.menu.atlas.AtlasPos;
import me.pigauts.voxelmenus.api.menu.atlas.InventoryWindow;
import me.pigauts.voxelmenus.api.menu.view.AtlasView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.type.AtlasMenu;

public class AtlasMenuView<T extends AtlasMenu, P extends MenuPlayer> extends MetaMenuView implements AtlasView {

    private final InventoryWindow window;

    public AtlasMenuView(T menu, P player) {
        this(menu, player, menu.getWindow());
    }

    public AtlasMenuView(T menu, P player, InventoryWindow window) {
        super(menu, player);
        this.window = window;
    }

    @Override
    public AtlasPos getWindowPosition() {
        return window.topLeftCorner();
    }

    @Override
    public void setWindowPosition(AtlasPos position) {
        window.setPosition(position);
        update();
        viewer.runFunction(getInventoryMeta().getFunction(MenuFunction.ATLAS_SCROLL));
    }

    @Override
    public void scroll(int x, int y) {
        window.translate(x, y);
        update();
        viewer.runFunction(getInventoryMeta().getFunction(MenuFunction.ATLAS_SCROLL));
    }

    @Override
    public void scroll(ScrollDirection direction) {
        scroll(direction.getX(), direction.getY());
    }

    @Override
    public void scroll(ScrollDirection direction, int amount) {
        int x, y;
        scroll((x = direction.getX()) == 0 ? x : x * amount, (y = direction.getY()) == 0 ? y : y * amount);
    }

}
