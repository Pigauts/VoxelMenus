package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.inventory.ItemStack;

public class SetItemAction implements Action {

    private final ItemStack item;
    private final int[] slots;

    public SetItemAction(ItemStack item, int[] slots) {
        this.item = item;
        this.slots = slots;
    }

    @Override
    public void execute(MenuPlayer player) {
        MenuView view = player.getOpenView();

        if (view == null) return;

        for (int slot : slots) {
            view.getInventory().setItem(slot, item);
        }
    }

}
