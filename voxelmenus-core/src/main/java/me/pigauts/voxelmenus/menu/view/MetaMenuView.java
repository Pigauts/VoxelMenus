package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.core.enums.MenuFunction;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import me.pigauts.voxelmenus.api.menu.view.MetaView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.api.core.InventoryUtils;
import org.jetbrains.annotations.NotNull;

public abstract class MetaMenuView<M extends Menu, P extends MenuPlayer> extends SimpleView<M, P> implements MetaView<M, P> {

    private InventoryMeta inventoryMeta;

    public MetaMenuView(@NotNull M menu, @NotNull P player) {
        this(menu, player, InventoryMeta.EMPTY_META);
    }

    public MetaMenuView(@NotNull M menu, @NotNull P player, @NotNull InventoryMeta inventoryMeta) {
        super(menu, player, InventoryUtils.createInventory(inventoryMeta.getTitle(), inventoryMeta.getStorage(), inventoryMeta.getSize()));
        this.inventoryMeta = inventoryMeta;
    }

    @Override
    public void open() {
        super.open();
        viewer.runFunction(inventoryMeta.getFunction(MenuFunction.OPEN));
    }

    @Override
    public void close() {
        super.close();
        viewer.runFunction(inventoryMeta.getFunction(MenuFunction.CLOSE));
    }

    public void update() {
        for (int i = 0; i < inventoryMeta.getSize(); i++) {
            TemplateButton templateButton = inventoryMeta.getTemplateButton(i);
            viewButtons[i] = templateButton != null ? templateButton.createViewButton(this) : null;
        }
        refresh();

        viewer.runFunction(inventoryMeta.getFunction(MenuFunction.UPDATE));
    }

    @Override
    public InventoryMeta getInventoryMeta() {
        return inventoryMeta;
    }

    @Override
    public void setInventoryMeta(@NotNull InventoryMeta inventoryMeta) {
        if (inventoryMeta == null) return;
        this.inventoryMeta = inventoryMeta;
    }

}
