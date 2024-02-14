package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.Menus;
import me.pigauts.voxelmenus.effect.animation.Animation;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SimpleView<M extends Menu, P extends MenuPlayer> implements MenuView {

    protected final M menu;
    protected final P player;
    private InventoryView inventory;
    private final List<Animation> playingAnimations = new ArrayList<>();

    public SimpleView(M menu, P player) {
        this.menu = menu;
        this.player = player;
    }

    @Override
    @NotNull
    public M getMenu() {
        return menu;
    }

    @Override
    @NotNull
    public P getPlayer() {
        return player;
    }

    @Override
    public InventoryView getInventory() {
        return inventory;
    }

    @Override
    public Inventory getTopInventory() {
        return inventory.getTopInventory();
    }

    @Override
    public Inventory getBottomInventory() {
        return inventory.getBottomInventory();
    }

    @Override
    public List<Animation> getPlayingAnimations() {
        return playingAnimations;
    }

    public Inventory createInventory() {
        return Menus.createInventory(menu.getStorage(), menu.getSize());
    }

    @Override
    public void open() {
        player.setOpenView(this);
        inventory = player.openInventory(createInventory());
        onOpen();
    }

    @Override
    public void close() {
        player.setOpenView(null);
        player.closeInventory();
        onClose();
    }

}
