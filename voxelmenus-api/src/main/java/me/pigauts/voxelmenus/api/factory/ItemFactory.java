package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface ItemFactory extends ConfigFactory<ItemStack> {

    @Override
    ItemStack create(Config config);

}
