package me.pigauts.voxelmenus.function.action.menu;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.inventory.*;

public class SetItem implements Action {

    private final ItemStack item;
    private final int slot;

    public SetItem(SlotItem item) {
        this(item.stack(), item.slot());
    }

    public SetItem(ItemStack item, int slot) {
        this.item = item;
        this.slot = slot;
    }

    @Override
    public void execute(MenuPlayer player) {
        if (!player.isViewingMenu()) return;
        player.getOpenView().getInventory().setItem(slot, item);
    }

}
