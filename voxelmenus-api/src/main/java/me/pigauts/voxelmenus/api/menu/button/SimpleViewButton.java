package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SimpleViewButton<T extends TemplateButton> implements ViewButton {

    protected final MenuView view;
    protected final T templateButton;

    public SimpleViewButton(MenuView view, T templateButton) {
        this.view = view;
        this.templateButton = templateButton;
    }

    @Override
    public ItemStack createViewItem() {
        return templateButton.getButtonItem();
    }

    @Override
    public void click(InventoryClickEvent event) {
        if (templateButton.isLocked()) {
            event.setCancelled(true);
        }
        view.getViewer().runFunction(templateButton.getFunction(event.getClick()));
    }
}
