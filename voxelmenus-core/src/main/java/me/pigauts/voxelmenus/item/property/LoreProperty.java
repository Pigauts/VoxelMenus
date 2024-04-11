package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.item.MetaProperty;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class LoreProperty implements MetaProperty {

    private final List<String> lore;

    public LoreProperty(List<String> lore) {
        this.lore = lore;
    }

    @Override
    public void apply(ItemMeta meta) {
        meta.setLore(lore);
    }

    @Override
    public void applyIfAbsent(ItemMeta meta) {
        if (!meta.hasLore()) apply(meta);
    }

}
