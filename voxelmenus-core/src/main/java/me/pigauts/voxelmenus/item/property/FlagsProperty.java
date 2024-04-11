package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.item.MetaProperty;
import me.pigauts.voxelmenus.util.Util;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public class FlagsProperty implements MetaProperty {

    private final ItemFlag[] flags;

    public FlagsProperty(Collection<ItemFlag> flags) {
        this.flags = Util.toNotNullArray(flags, new ItemFlag[0]);
    }

    @Override
    public void apply(ItemMeta meta) {
        meta.addItemFlags(flags);
    }

    @Override
    public void applyIfAbsent(ItemMeta meta) {
        if (meta.getItemFlags().isEmpty()) apply(meta);
    }

}
