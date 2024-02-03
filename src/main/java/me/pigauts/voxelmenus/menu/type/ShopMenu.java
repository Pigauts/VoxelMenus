package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.function.Function;

public class ShopMenu extends DynamicMenu {

    public ShopMenu(String name, String title, int size, int refreshTicks, Function openFunction, Function closeFunction, ConditionalMap<Contents> contentsByCondition) {
        super(name, title, size, refreshTicks, openFunction, closeFunction, contentsByCondition);
    }

}
