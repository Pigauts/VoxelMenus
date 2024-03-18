package me.pigauts.voxelmenus.core.function.action.world;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.inventory.ItemStack;

public class DropItem implements Action {

    private final ItemStack item;

    public DropItem(ItemStack item) {
        this.item = item;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.getWorld().dropItemNaturally(player.getLocation(), item);
    }

}
