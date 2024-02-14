package me.pigauts.voxelmenus.menu.widget;

import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.function.ClickFunction;
import org.bukkit.inventory.ItemStack;

public class Button extends Icon {

    private final ClickFunction function;

    public Button(ItemStack item, ClickFunction function) {
        this(item, function, true);
    }

    public Button(ItemStack item, ClickFunction function, boolean locked) {
        super(item, locked);
        this.function = function;
    }


    @Override
    public void onClick(MenuClickEvent event) {
        super.onClick(event);
        function.run(event.getPlayer(), event.getClick());
    }

}
