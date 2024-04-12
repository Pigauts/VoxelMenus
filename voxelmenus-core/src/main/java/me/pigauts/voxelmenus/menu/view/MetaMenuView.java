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

    private InventoryMeta meta;

    public MetaMenuView(@NotNull M menu, @NotNull P player) {
        this(menu, player, InventoryMeta.EMPTY_META);
    }

    public MetaMenuView(@NotNull M menu, @NotNull P player, @NotNull InventoryMeta meta) {
        super(menu, player, InventoryUtils.createInventory(menu, meta));
        this.meta = meta;
    }

    @Override
    public void open() {
        super.open();
        viewer.runFunction(meta.getFunction(MenuFunction.OPEN));
    }

    @Override
    public void close() {
        super.close();
        viewer.runFunction(meta.getFunction(MenuFunction.CLOSE));
    }

    @Override
    public void update() {
        for (int i = 0; i < menu.getSize(); i++) {
            TemplateButton templateButton = meta.getTemplateButton(i);
            viewButtons[i] = templateButton != null ? templateButton.createViewButton(this) : null;
        }
        super.update();

        if (!isClosed()) {
            viewer.runFunction(meta.getFunction(MenuFunction.UPDATE));
        }
    }

    @Override
    public InventoryMeta getMenuMeta() {
        return meta;
    }

    @Override
    public void setMenuMeta(@NotNull InventoryMeta meta) {
        if (meta == null) return;
        this.meta = meta;
    }

}
