package me.pigauts.voxelmenus.api;

import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.factory.*;
import me.pigauts.voxelmenus.api.flag.Flag;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.MenuEntryButtons;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface VoxelMenus {

    @NotNull
    World getWorld();

    @Nullable
    MenuPlayer getPlayer(UUID playerId);

    @Nullable
    Menu getMenu(String menuId);

    @Nullable
    ItemStack getItem(String itemId);

    @Nullable
    Flag getFlag(String flagId);

    @NotNull
    List<ItemStack> getItems(Collection<String> itemsIds);

    @Nullable
    TemplateButton getTemplateButton(String iconId);

    @Nullable
    Function getFunction(String functionId);

    @Nullable
    Animation getAnimation(String animationId);

    @Nullable
    Message getMessage(String messageId);

    @Nullable
    Command getCommand(String commandId);

    @Nullable
    MenuEntryButtons getEntries(String entriesId);

    @Nullable
    MenuFactory getMenuFactory(String factoryId);

    @Nullable
    MessageFactory getMessageFactory(String factoryId);

    @NotNull
    PlayerFactory getPlayerFactory();

    @Nullable
    FunctionFactory getFunctionFactory(String factoryId);

    @Nullable
    ConditionFactory getConditionFactory(String factoryId);

    @Nullable
    ActionFactory getActionFactory(String factoryId);

}
