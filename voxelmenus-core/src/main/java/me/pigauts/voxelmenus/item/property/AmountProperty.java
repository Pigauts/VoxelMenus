package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.api.item.ItemProperty;
import org.bukkit.inventory.ItemStack;

public class AmountProperty implements ItemProperty {

    private final int amount;

    public AmountProperty(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(ItemStack item) {
        item.setAmount(amount);
    }

    @Override
    public void applyIfAbsent(ItemStack item) {
        if (item.getAmount() == 0) apply(item);
    }

}
