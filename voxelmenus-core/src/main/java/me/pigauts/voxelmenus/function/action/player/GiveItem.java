package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;
import org.bukkit.inventory.ItemStack;

public class GiveItem implements Action {

    private final ItemStack item;

    public GiveItem(ItemStack item) {
        this.item = item;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.giveItem(item);
    }

}
