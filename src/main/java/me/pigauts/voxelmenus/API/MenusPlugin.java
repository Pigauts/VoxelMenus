package me.pigauts.voxelmenus.API;

import me.pigauts.voxelmenus.API.factory.*;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.animation.Animation;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.message.Message;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface MenusPlugin extends VoxelPlugin {

    @NotNull
    World getWorld();

    @Nullable
    MenuPlayer getPlayer(UUID playerId);

    @Nullable
    Menu getMenu(String menuId);

    @Nullable
    ItemStack getItem(String itemId);

    @NotNull
    List<ItemStack> getItems(Collection<String> itemsIds);

    @Nullable
    Button getCustomButton(String iconId);

    @Nullable
    FunctionSet getCustomFunction(String functionId);

    @Nullable
    Animation getAnimation(String animationId);

    @Nullable
    Message getMessage(String messageId);

    @Nullable
    Command getCommand(String commandId);

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
