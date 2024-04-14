package me.pigauts.voxelmenus.function.action.world;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.api.function.Action;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class DropItems implements Action {

    private final ItemStack[] items;

    public DropItems(Collection<ItemStack> items) {
        this.items = Util.toNotNullArray(items, new ItemStack[0]);
    }

    @Override
    public void execute(MenuPlayer player) {
        for (ItemStack itemStack : items) {
            player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
        }
    }
}
