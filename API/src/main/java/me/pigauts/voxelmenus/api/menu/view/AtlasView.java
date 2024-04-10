package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.ScrollDirection;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.util.atlas.AtlasPos;

public interface AtlasView<M extends Menu, P extends MenuPlayer> extends MetaView<M, P> {

    AtlasPos getWindowPosition();

    void setWindowPosition(AtlasPos position);

    void scroll(int x, int y);

    void scroll(ScrollDirection direction);

    void scroll(ScrollDirection direction, int amount);

}
