package me.pigauts.voxelmenus.core.function.action.menu;

import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.util.SlotItem;

import java.util.Collection;

public class SetItems implements Action {

    private final SlotItem[] items;

    public SetItems(Collection<SlotItem> items) {
        this.items = Util.toNotNullArray(items, new SlotItem[0]);
    }

    @Override
    public void execute(MenuPlayer player) {
        if (!player.isViewingMenu()) return;
        MenuView view = player.getOpenView();

        for (SlotItem item : items) {
            view.getInventory().setItem(item.slot(), item.stack());
        }
    }

}
