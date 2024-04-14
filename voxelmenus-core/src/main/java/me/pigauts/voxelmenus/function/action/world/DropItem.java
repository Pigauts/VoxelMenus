package me.pigauts.voxelmenus.function.action.world;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.inventory.*;

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
