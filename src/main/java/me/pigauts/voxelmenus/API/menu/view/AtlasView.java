package me.pigauts.voxelmenus.API.menu.view;

import me.pigauts.voxelmenus.API.AtlasScroll;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.util.AtlasPos;

public interface AtlasView<M extends Menu, P extends MenuPlayer> extends MetaView<M, P> {

    AtlasPos getPosition();

    void setPosition(AtlasPos position);

    void scroll(int x, int y);

    void scroll(AtlasScroll direction);

    void scroll(AtlasScroll direction, int amount);

}
