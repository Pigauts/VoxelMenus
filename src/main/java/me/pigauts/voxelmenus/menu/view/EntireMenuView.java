package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.effect.animation.Animation;
import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.type.EntireMenu;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.util.List;

public class EntireMenuView implements MenuView {

    private final EntireMenu menu;
    private final MenuPlayer player;

    private final MenuView topView;

    public <M extends Menu> EntireMenuView(EntireMenu<M> menu, MenuPlayer player) {
        this.menu = menu;
        this.player = player;
        this.topView = menu.getTopMenu().createView(player);
    }

    @Override
    public Menu getMenu() {
        return topView.getMenu();
    }

    @Override
    public MenuPlayer getPlayer() {
        return topView.getPlayer();
    }

    @Override
    public InventoryView getInventory() {
        return topView.getInventory();
    }

    @Override
    public Inventory getTopInventory() {
        return topView.getTopInventory();
    }

    @Override
    public Inventory getBottomInventory() {
        return topView.getBottomInventory();
    }

    @Override
    public List<Animation> getPlayingAnimations() {
        return topView.getPlayingAnimations();
    }

    @Override
    public void open() {
        topView.open();

        player.cacheInventory();
        player.getInventory().clear();

        getBottomInventory().setContents(menu.getBottomContents());

        onOpen();
    }

    @Override
    public void close() {
        topView.close();

        player.restoreInventory();

        onClose();
    }

    @Override
    public void onUpdate() {
        topView.onUpdate();
    }

    @Override
    public void onClick(MenuClickEvent event) {
        topView.onClick(event);
    }


}
