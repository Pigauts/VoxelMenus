package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.API.Menus;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.animation.Animation;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SimpleView<M extends Menu, P extends MenuPlayer> implements MenuView<M, P> {

    protected MenuView previousView;
    protected final M menu;
    protected final P player;
    protected @NotNull Inventory inventory;
    private final List<Animation> playingAnimations = new ArrayList<>();

    public SimpleView(@NotNull M menu, @NotNull P player) {
        this(menu, player, Menus.createInventory(menu));
    }

    public SimpleView(@NotNull M menu, @NotNull P player, @NotNull Inventory inventory) {
        this.menu = menu;
        this.player = player;
        this.inventory = inventory;
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
    public P getPlayer() {
        return player;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public List<Animation> getPlayingAnimations() {
        return playingAnimations;
    }

    @Override
    public void open() {
        player.setOpenView(this);
        player.openInventory(inventory);
    }

    @Override
    public void close() {
        player.setOpenView(null);
        player.closeInventory();
    }

    @Override
    public void update() { }

    @Override
    public void refresh() { }

    @Override
    public void back() {
        player.openView(previousView);
    }

    @Override
    public void click(InventoryClickEvent event) { }

}
