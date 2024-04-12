package me.pigauts.voxelmenus.api.core.placeholder;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record Placeholder(String id, Object value) {

    public static final Placeholder EMPTY_PLACEHOLDER = new Placeholder("", "");

    @NotNull
    public static Placeholder of(String id, Object value) {
        if (id == null || value == null) return EMPTY_PLACEHOLDER;
        return new Placeholder(id, value);
    }

    public String apply(String s) {
        return s.replaceAll(id, value.toString());
    }

    public ItemMeta apply(ItemMeta meta) {
        if (meta != null) {
            meta.setDisplayName(apply(meta.getDisplayName()));

            List<String> lore = meta.getLore();
            for (int i = 0; i < lore.size(); i++) {
                lore.set(i, apply(lore.get(i)));
            }
            meta.setLore(lore);
        }
        return meta;
    }

    public ItemStack apply(ItemStack item) {
        item.setItemMeta(apply(item.getItemMeta()));
        return item;
    }

}
