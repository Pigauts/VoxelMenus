package me.pigauts.voxelmenus.api.menu.view;

import me.pigauts.voxelmenus.api.core.enums.ScrollDirection;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.atlas.AtlasPos;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public interface AtlasView<M extends Menu, P extends MenuPlayer> extends MetaView<M, P> {

    AtlasPos getWindowPosition();

    void setWindowPosition(AtlasPos position);

    void scroll(int x, int y);

    void scroll(ScrollDirection direction);

    void scroll(ScrollDirection direction, int amount);

}
