package me.pigauts.voxelmenus.api.event.menu;

import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

public class MenuClickEvent extends MenuEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final InventoryClickEvent event;

    public MenuClickEvent(MenuView view, InventoryClickEvent event) {
        super(view);
        this.event = event;
    }

    public List<HumanEntity> getViewers() {
        return event.getViewers();
    }

    public InventoryView getInventoryView() {
        return event.getView();
    }

    public HumanEntity getWhoClicked() { return event.getWhoClicked(); }

    public Inventory getClickedInventory() {
        return event.getClickedInventory();
    }

    public ItemStack getCursor() {
        return event.getCursor();
    }

    public ItemStack getCurrentItem() {
        return event.getCurrentItem();
    }

    public boolean isRightClick() {
        return event.isRightClick();
    }

    public boolean isLeftClick() {
        return event.isLeftClick();
    }

    public boolean isShiftClick() {
        return event.isShiftClick();
    }

    public void setCursor(@Nullable ItemStack stack) {
        event.getView().setCursor(stack);
    }

    public void setCurrentItem(@Nullable ItemStack stack) {
        event.setCurrentItem(stack);
    }

    public Inventory getInventory() {
        return event.getInventory();
    }

    public int getSlot() {
        return event.getSlot();
    }

    public int getRawSlot() {
        return event.getRawSlot();
    }

    public int getHotbarButton() {
        return event.getHotbarButton();
    }

    public InventoryAction getAction() {
        return event.getAction();
    }

    public ClickType getClick() {
        return event.getClick();
    }

    public void cancelClickEvent(boolean bool) {
        event.setCancelled(bool);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
