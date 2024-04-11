package me.pigauts.voxelmenus.item.property;

import me.pigauts.voxelmenus.item.MetaProperty;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class AttributesProperty implements MetaProperty {

    private final Map<Attribute, AttributeModifier> attributes;

    public AttributesProperty(Map<Attribute, AttributeModifier> attributes) {
        this.attributes = attributes;
    }

    @Override
    public void apply(ItemMeta meta) {
        for (Map.Entry<Attribute, AttributeModifier> entry : attributes.entrySet())
        meta.addAttributeModifier(entry.getKey(), entry.getValue());
    }

    @Override
    public void applyIfAbsent(ItemMeta meta) {
        if (meta.getAttributeModifiers().isEmpty()) apply(meta);
    }

}
