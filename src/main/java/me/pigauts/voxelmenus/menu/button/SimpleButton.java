package me.pigauts.voxelmenus.menu.button;

import me.pigauts.voxelmenus.event.MenuClickEvent;
import me.pigauts.voxelmenus.function.ClickFunction;
import org.bukkit.inventory.ItemStack;

public class SimpleButton implements Button {

    private final ItemStack item;
    private final ClickFunction function;

    public SimpleButton(ItemStack item, ClickFunction function) {
        this.item = item;
        this.function = function;
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public void onClick(MenuClickEvent event) {
        function.run(event.getPlayer(), event.getClick());
    }

}
