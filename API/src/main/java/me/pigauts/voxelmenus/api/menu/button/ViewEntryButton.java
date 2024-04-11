package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.inventory.ItemStack;

public class ViewEntryButton extends SimpleViewButton<TemplateEntryButton> {

    public ViewEntryButton(MenuView view, TemplateEntryButton templateButton) {
        super(view, templateButton);
    }

    @Override
    public ItemStack createViewItem() {
        return templateButton.getButtonItem();
    }

}
