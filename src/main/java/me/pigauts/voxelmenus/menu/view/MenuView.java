package me.pigauts.voxelmenus.menu.view;

import me.pigauts.voxelmenus.effect.animation.Animation;
import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MenuView<M extends Menu, P extends MenuPlayer> {

    @NotNull
    M getMenu();

    @NotNull
    P getPlayer();

    InventoryView getInventory();

    Inventory getTopInventory();

    Inventory getBottomInventory();

    @NotNull
    List<Animation> getPlayingAnimations();

    void open();

    void close();

    default void onOpen() {}

    default void onClose() {}

    default void onUpdate() {}

    default void onClick(@NotNull MenuClickEvent event) {}

}
