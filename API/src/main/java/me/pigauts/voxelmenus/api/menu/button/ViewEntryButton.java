package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.item.ItemProperty;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.core.placeholder.Placeholder;
import org.bukkit.inventory.ItemStack;

public class ViewEntryButton extends SimpleViewButton<TemplateEntryButton> {

    public ViewEntryButton(MenuView view, TemplateEntryButton templateButton) {
        super(view, templateButton);
    }

    @Override
    public ItemStack createViewItem() {
        ItemStack item = templateButton.getButtonItem();

        for (ItemProperty property : templateButton.getItemProperties()) {
            property.applyIfAbsent(item);
        }

        for (Placeholder placeholder : templateButton.getPlaceholders()) {
            placeholder.apply(item);
        }

        return item;
    }

}
