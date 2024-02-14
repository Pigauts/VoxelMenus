package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class GiveItemAction implements Action {

    private final ItemStack[] items;

    public GiveItemAction(ItemStack[] items) {
        this.items = items;
    }

    @Override
    public void execute(MenuPlayer player) {
        for (Map.Entry<Integer, ItemStack> entry : player.getInventory().addItem(items).entrySet()) {
            player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
        }
    }

}
