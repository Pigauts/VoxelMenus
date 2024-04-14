package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import org.bukkit.inventory.*;

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
