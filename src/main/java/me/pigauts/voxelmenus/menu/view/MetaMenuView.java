package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.Menus;
import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.type.SimpleMenu;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.inventory.Inventory;

public abstract class MetaMenuView<M extends Menu, P extends MenuPlayer> extends SimpleView<M, P> {

    private MenuMeta meta;

    public MetaMenuView(M menu, P player) {
        super(menu, player);
    }

    public abstract MenuMeta getMenuMeta();

    @Override
    public Inventory createInventory() {
        Inventory inventory = Menus.createInventory(meta.getTitle(), menu.getStorage(), menu.getSize());
        inventory.setContents(meta.getIcons());

        return inventory;
    }

    @Override
    public void open() {
        meta = getMenuMeta();
        super.open();

        player.executeFunction(meta.getOpenFunction());
    }

    @Override
    public void onClose() {
        player.executeFunction(meta.getCloseFunction());
    }

    @Override
    public void onUpdate() {
        this.meta = getMenuMeta();
        getTopInventory().setContents(meta.getIcons());

        player.executeFunction(meta.getUpdateFunction());
    }

    @Override
    public void onClick(MenuClickEvent event) {
        int slot = event.getRawSlot();

        if (slot >= 0 && slot < menu.getSize()) {
            Icon button = meta.getIcon(slot);

            if (button != null) {
                button.onClick(event);
                return;
            }

            if (menu.lockEmpty()) {
                event.cancelClickEvent(true);
            }

            return;
        }

        if (menu.lockBottom()) {
            event.cancelClickEvent(true);
        }
    }

}
