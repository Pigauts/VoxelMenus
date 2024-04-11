package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.item.MetaProperty;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class EnchantsProperty implements MetaProperty {

    private final Map<Enchantment, Integer> enchants;

    public EnchantsProperty(Map<Enchantment, Integer> enchants) {
        this.enchants = enchants;
    }

    @Override
    public void apply(ItemMeta meta) {
        for (Map.Entry<Enchantment, Integer> entry : enchants.entrySet()) {
            meta.addEnchant(entry.getKey(), entry.getValue(), true);
        }
    }

    @Override
    public void applyIfAbsent(ItemMeta meta) {
        if (meta.getEnchants().isEmpty()) apply(meta);
    }

}
