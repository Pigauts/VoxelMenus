package me.pigauts.voxelmenus.menu.widget;

import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import org.bukkit.inventory.ItemStack;

public class Icon extends ItemStack {

    public static final Icon[] EMPTY_WIDGETS = new Icon[54];

    private boolean locked = true;

    public Icon(ItemStack item) {
        super(item);
    }

    public Icon(ItemStack item, boolean locked) {
        super(item);
        this.locked = locked;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void onClick(MenuClickEvent event) {
        if (locked) event.cancelClickEvent(true);
    }

}
