package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.effect.animation.Animation;
import me.pigauts.voxelmenus.event.MenuClickEvent;
import me.pigauts.voxelmenus.function.ClickFunction;
import me.pigauts.voxelmenus.user.MenuPlayer;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenMenu {

    private final MenuPlayer player;
    private final Menu menu;
    private Inventory inventory;
    private ItemStack[] contents;
    private ClickFunction[] buttons;
    private Animation runningAnimation = null;

    public OpenMenu(MenuPlayer player, Menu menu) {
        this.player = player;
        this.menu = menu;
        this.inventory = Bukkit.createInventory(null, menu.getSize(), menu.getTitle());
        update();
    }

    public Menu getMenu() {
        return menu;
    }

    public MenuPlayer getPlayer() {
        return player;
    }

    public String getName() {
        return menu.getName();
    }

    public String getTitle() {
        return menu.getTitle();
    }

    public int getSize() {
        return menu.getSize();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ItemStack[] getContents() { return inventory.getContents(); }

    public ItemStack[] getRawContents() {
        return contents;
    }

    public void onClick(MenuClickEvent event) {
        menu.onClick(event);
    }

    public void update() {
        this.contents = menu.getItems(player);
        this.inventory.setContents(contents);
    }

}
