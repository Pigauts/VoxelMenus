package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.inventory.*;

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
