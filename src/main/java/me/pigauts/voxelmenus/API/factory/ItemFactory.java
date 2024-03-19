package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface ItemFactory extends ConfigFactory<ItemStack> {

    @Override
    ItemStack create(Config config);

}
