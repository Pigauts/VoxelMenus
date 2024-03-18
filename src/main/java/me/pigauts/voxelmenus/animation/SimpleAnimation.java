package me.pigauts.voxelmenus.animation;

import me.pigauts.voxelmenus.API.menu.MenuView;
import org.bukkit.inventory.Inventory;

public abstract class SimpleAnimation implements Animation {

    private final int frequency;
    private final int repetitions;

    protected SimpleAnimation(int frequency, int repetitions) {
        this.frequency = frequency;
        this.repetitions = repetitions;
    }

    @Override
    public void play(MenuView view) {

        onUpdate(view.getInventoryView().getTopInventory(), 1);

    }

    abstract void onUpdate(Inventory inventory, int frame);

}
