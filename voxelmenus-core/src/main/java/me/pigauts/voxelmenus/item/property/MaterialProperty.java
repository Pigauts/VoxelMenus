package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.api.item.ItemProperty;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialProperty implements ItemProperty {

    private final Material material;

    public MaterialProperty(Material material) {
        this.material = material;
    }

    @Override
    public void apply(ItemStack item) {
        item.setType(material);
    }

    @Override
    public void applyIfAbsent(ItemStack item) {
        if (item.getType() == Material.AIR) apply(item);
    }

}
