package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.flag.FlagMap;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.placeholder.PlaceholderMap;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class TemplateEntryButton extends SimpleTemplateButton {

    private final String name;
    private final FlagMap flags;
    private final PlaceholderMap placeholders;

    public TemplateEntryButton(ItemStack buttonItem, Map<ClickType, Function> functions, boolean locked, String name, FlagMap flags, PlaceholderMap placeholders) {
        super(buttonItem, functions, locked);
        this.name = name;
        this.flags = flags;
        this.placeholders = placeholders;
    }

    @Override
    public ViewButton createViewButton(MenuView view) {
        return new ViewEntryButton(view, this);
    }

}
