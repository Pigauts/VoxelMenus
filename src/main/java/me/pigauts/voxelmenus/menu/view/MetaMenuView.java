package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.MenuAction;
import me.pigauts.voxelmenus.API.Menus;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.API.menu.view.MetaView;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public abstract class MetaMenuView<M extends Menu, P extends MenuPlayer> extends SimpleView<M, P> implements MetaView<M, P> {

    protected @NotNull MenuMeta meta;

    public MetaMenuView(@NotNull M menu, @NotNull P player) {
        this(menu, player, MenuMeta.EMPTY_META);
    }

    public MetaMenuView(@NotNull M menu, @NotNull P player, @NotNull MenuMeta meta) {
        super(menu, player, Menus.createInventory(menu, meta));
        this.meta = meta;
    }

    @Override
    public void open() {
        super.open();
        player.executeFunction(meta.getFunction(MenuAction.OPEN));
    }

    @Override
    public void close() {
        super.close();
        player.executeFunction(meta.getFunction(MenuAction.CLOSE));
    }

    @Override
    public void update() {
        inventory.setContents(meta.getButtons());
        player.updateInventory();
        player.executeFunction(meta.getFunction(MenuAction.UPDATE));
    }

    @Override
    public void click(InventoryClickEvent event) {
        int slot = event.getRawSlot();

        if (slot >= 0 && slot < menu.getSize()) {
            Button button = meta.getButton(slot);

            if (button != null) {
                button.click(player, event);
                return;
            }

            if (menu.lockEmpty()) {
                event.setCancelled(true);
            }

            return;
        }

        if (menu.lockBottom()) {
            event.setCancelled(true);
        }
    }

    @Override
    public MenuMeta getMenuMeta() {
        return meta;
    }

    @Override
    public void setMenuMeta(@NotNull MenuMeta meta) {
        if (meta == null) return;
        this.meta = meta;
    }

}
