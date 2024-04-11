package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.flag.FlagMap;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.item.ItemProperty;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.core.placeholder.PlaceholderMap;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;

public class TemplateEntryButton extends SimpleTemplateButton {

    private final String name;
    private final FlagMap flags;
    private final PlaceholderMap placeholders;
    private final List<ItemProperty> itemProperties;

    public TemplateEntryButton(ItemStack buttonItem, Map<ClickType, Function> functions, boolean locked, String name, FlagMap flags, PlaceholderMap placeholders, List<ItemProperty> itemProperties) {
        super(buttonItem, functions, locked);
        this.name = name;
        this.flags = flags;
        this.placeholders = placeholders;
        this.itemProperties = itemProperties;
    }

    @Override
    public ViewButton createViewButton(MenuView view) {
        return new ViewEntryButton(view, this);
    }

    public String getName() {
        return name;
    }

    public FlagMap getFlags() {
        return flags;
    }

    public PlaceholderMap getPlaceholders() {
        return placeholders;
    }

    public List<ItemProperty> getItemProperties() {
        return itemProperties;
    }

}
