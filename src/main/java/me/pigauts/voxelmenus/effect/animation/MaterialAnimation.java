package me.pigauts.voxelmenus.effect.animation;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MaterialAnimation extends SimpleAnimation {

    private final List<Material[]> frames;

    protected MaterialAnimation(int frequency, int repetitions, List<Material[]> frames) {
        super(frequency, repetitions);
        this.frames = frames;
    }

    @Override
    void onUpdate(Inventory inventory, int frame) {

        ItemStack[] contents = inventory.getContents();
        Material[] materials = frames.get(frame);

        for (int i = 0; i < contents.length; i++) {
            contents[i].setType(materials[i]);
        }

    }

}
