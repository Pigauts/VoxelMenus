package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.event.MenuClickEvent;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.button.Button;
import me.pigauts.voxelmenus.user.MenuPlayer;

public class StaticMenu extends SimpleMenu {

    private final Button[] buttons;

    public StaticMenu(String name, String title, int size, int refreshTicks, Function openFunction, Function closeFunction, Button[] buttons) {
        super(name, title, size, refreshTicks, openFunction, closeFunction);
        this.buttons = buttons;
    }

    @Override
    public Button[] getButtons(MenuPlayer player) {
        return buttons;
    }

}
