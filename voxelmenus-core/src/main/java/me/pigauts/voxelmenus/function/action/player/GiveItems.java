package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;
import me.pigauts.voxelmenus.util.*;
import org.bukkit.inventory.*;

import java.util.*;

public class GiveItems implements Action {

    private final ItemStack[] items;

    public GiveItems(Collection<ItemStack> items) {
        this.items = Utils.toNotNullArray(items, new ItemStack[0]);
    }

    @Override
    public void execute(MenuPlayer player) {
        player.giveItem(items);
    }

}
