package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.user.MenuPlayer;
import org.bukkit.inventory.ItemStack;

public class DropItemAction implements Action {

    private final ItemStack[] items;

    public DropItemAction(ItemStack[] items) {
        this.items = items;
    }

    @Override
    public void execute(MenuPlayer player) {
        for (ItemStack itemStack : items) {
            player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
        }
    }
}
