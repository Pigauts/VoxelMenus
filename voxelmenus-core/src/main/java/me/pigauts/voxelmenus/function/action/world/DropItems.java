package me.pigauts.voxelmenus.function.action.world;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.inventory.*;

import java.util.*;

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
