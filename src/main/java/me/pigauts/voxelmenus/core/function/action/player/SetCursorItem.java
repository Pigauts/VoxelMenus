package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.inventory.ItemStack;

public class SetCursorItem implements Action {

    private final ItemStack item;

    public SetCursorItem(ItemStack item) {
        this.item = item;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.asPlayer().setItemOnCursor(item);
    }

}
