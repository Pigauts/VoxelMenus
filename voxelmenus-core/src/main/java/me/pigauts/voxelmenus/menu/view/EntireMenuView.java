package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.menu.type.EntireMenu;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.Nullable;

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
    public @Nullable MenuView getPreviousView() {
        return topView.getPreviousView();
    }

    @Override
    public void setPreviousView(MenuView previousView) {
        topView.setPreviousView(previousView);
    }

    @Override
    public Menu getMenu() {
        return topView.getMenu();
    }

    @Override
    public MenuPlayer getViewer() {
        return topView.getViewer();
    }

    @Override
    public Inventory getInventory() {
        return topView.getInventory();
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
//        player.getInventory().setContents(menu.getBottomContents());
    }

    @Override
    public void close() {
        topView.close();
        player.restoreInventory();
    }

    @Override
    public void update() {
        topView.update();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void back() {

    }

    @Override
    public void click(InventoryClickEvent event) {
        topView.click(event);
    }


}
