package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.api.function.Action;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class GiveItems implements Action {

    private final ItemStack[] items;

    public GiveItems(Collection<ItemStack> items) {
        this.items = Util.toNotNullArray(items, new ItemStack[0]);
    }

    @Override
    public void execute(MenuPlayer player) {
        player.giveItem(items);
    }

}
