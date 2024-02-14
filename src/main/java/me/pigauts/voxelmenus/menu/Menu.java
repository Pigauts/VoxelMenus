package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.event.menu.MenuClickEvent;
import me.pigauts.voxelmenus.event.menu.MenuCloseEvent;
import me.pigauts.voxelmenus.event.menu.MenuOpenEvent;
import me.pigauts.voxelmenus.event.menu.MenuUpdateEvent;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public interface Menu {

    @NotNull
    String getName();

    @NotNull
    InventoryType getStorage();

    int getSize();

    int getRefresh();

    boolean keepOpen();

    boolean lockBottom();

    boolean lockEmpty();

    @NotNull
    MenuView createView(@NotNull MenuPlayer player);

    default void onOpen(@NotNull MenuOpenEvent event) {}

    default void onClose(@NotNull MenuCloseEvent event) {}

    default void onUpdate(@NotNull MenuUpdateEvent event) {}

    default void onClick(@NotNull MenuClickEvent event) {}

}
