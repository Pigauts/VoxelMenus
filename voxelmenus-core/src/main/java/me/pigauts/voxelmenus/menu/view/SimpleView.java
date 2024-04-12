package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.button.SimpleViewButton;
import me.pigauts.voxelmenus.api.menu.button.ViewButton;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.api.core.InventoryUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SimpleView<M extends Menu, P extends MenuPlayer> implements MenuView<M, P> {

    private MenuView previousView;
    protected final M menu;
    protected final P viewer;
    protected final Inventory inventory;
    protected final ViewButton[] viewButtons;
    private final List<Animation> playingAnimations = new ArrayList<>();

    private boolean closed = true;

    public SimpleView(@NotNull M menu, @NotNull P player) {
        this(menu, player, InventoryUtils.createInventory(menu));
    }

    public SimpleView(@NotNull M menu, @NotNull P viewer, @NotNull Inventory inventory) {
        Validate.notNull(menu, "Menu cannot be null");
        Validate.notNull(viewer, "Viewer cannot be null");
        Validate.notNull(inventory, "Inventory cannot be null");
        this.menu = menu;
        this.viewer = viewer;
        this.inventory = inventory;
        this.viewButtons = new SimpleViewButton[menu.getSize()];
    }

    @Override
    public MenuView getPreviousView() {
        return previousView;
    }

    @Override
    public void setPreviousView(MenuView previousView) {
        this.previousView = previousView;
    }

    @Override
    public M getMenu() {
        return menu;
    }

    @Override
    public P getViewer() {
        return viewer;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public ViewButton[] getButtons() {
        return viewButtons;
    }

    @Override
    public boolean isClosed() {
        return closed;
    }

    @Override
    public List<Animation> getPlayingAnimations() {
        return playingAnimations;
    }

    @Override
    public void open() {
        viewer.setOpenView(this);
        viewer.openInventory(inventory);
        update();
        closed = false;
    }

    @Override
    public void close() {
        closed = true;
        viewer.closeInventory();
        viewer.setOpenView(null);
    }

    @Override
    public void update() {
        ItemStack[] contents = new ItemStack[menu.getSize()];

        for (int i = 0; i < menu.getSize(); i++) {
            ViewButton viewButton = viewButtons[i];
            contents[i] = viewButton != null ? viewButton.createViewItem() : null;
        }

        inventory.setContents(contents);
        viewer.updateInventory();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void back() {
        viewer.openView(previousView);
    }

    @Override
    public void click(InventoryClickEvent event) {
        int slot = event.getRawSlot();

        if (slot < 0) {
            event.setCancelled(true);
            return;
        }

        if (slot < menu.getSize()) {
            ViewButton button = viewButtons[slot];

            if (button != null) {
                button.click(event);
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

}
