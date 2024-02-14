package me.pigauts.voxelmenus.effect.animation;

import me.pigauts.voxelmenus.menu.view.MenuView;
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

        onUpdate(view.getInventory().getTopInventory(), 1);

    }

    abstract void onUpdate(Inventory inventory, int frame);

}
