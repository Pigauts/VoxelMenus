package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.API.MenusPlugin;
import me.pigauts.voxelmenus.API.factory.*;
import me.pigauts.voxelmenus.animation.Animation;
import me.pigauts.voxelmenus.command.CommandManager;
import me.pigauts.voxelmenus.command.menu.MenusCommand;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.FactoryManager;
import me.pigauts.voxelmenus.animation.AnimationManager;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.message.Message;
import me.pigauts.voxelmenus.message.MessageManager;
import me.pigauts.voxelmenus.item.ItemManager;
import me.pigauts.voxelmenus.core.listener.InventoryEventsListener;
import me.pigauts.voxelmenus.core.listener.PlayerJoinQuitListener;
import me.pigauts.voxelmenus.menu.MenuManager;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.player.PlayerManager;
import me.pigauts.voxelmenus.util.ConfigManager;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class VoxelMenusPlugin extends JavaPlugin implements MenusPlugin {

    private final PlayerManager playerManager = new PlayerManager(this);
    private final MenuManager menuManager = new MenuManager(this);
    private final ItemManager itemManager = new ItemManager(this);
    private final AnimationManager animationManager = new AnimationManager(this);
    private final MessageManager messageManager = new MessageManager(this);
    private final CommandManager commandManager = new CommandManager(this);
    private final FactoryManager factoryManager = new FactoryManager(this);
    private final ConfigManager configManager = new ConfigManager(this);

    private World world;

    private static VoxelMenusPlugin plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {

        createFiles();

        registerEvents(new PlayerJoinQuitListener(this));
        registerEvents(new InventoryEventsListener(this));

        itemManager.load();
        menuManager.load();
        messageManager.load();
        animationManager.load();

        commandManager.addCommand(new MenusCommand());
        commandManager.registerAll();

        playerManager.load();

    }

    @Override
    public void onDisable() {

    }

    private void createFiles() {
        createPluginFolder();
        createFolder("items");
        createFolder("menus");
        createFolder("messages");
        createFolder("placeholders");
        createFolder("triggers");

        ConfigSection config = getConfig("config.yml");

        if (config.getBoolean("generate-examples", true)) {
            createFile("menus/ExampleStatic.yml");
            createFile("menus/ExampleDynamic.yml");
            createFile("menus/ExamplePaged.yml");
            createFile("menus/ExampleAtlas.yml");
            createFile("menus/ExampleFull.yml");
        }

    }

    public static VoxelMenusPlugin getPlugin() {
        return plugin;
    }

    public PlayerManager getPlayers() {
        return playerManager;
    }

    public MenuManager getMenus() {
        return menuManager;
    }

    public ItemManager getItems() {
        return itemManager;
    }

    public AnimationManager getAnimations() {
        return animationManager;
    }

    public MessageManager getMessages() {
        return messageManager;
    }

    public CommandManager getCommands() {
        return  commandManager;
    }

    public FactoryManager getFactories() {
        return factoryManager;
    }

    @Override
    public @NotNull World getWorld() {
        return world;
    }

    @Override
    public MenuPlayer getPlayer(UUID playerId) {
        return playerManager.getPlayer(playerId);
    }

    @Override
    public Menu getMenu(String menuId) {
        return menuManager.getMenu(menuId);
    }

    @Override
    public ItemStack getItem(String itemId) {
        return itemManager.getItem(itemId);
    }

    @Override
    public List<ItemStack> getItems(Collection<String> itemsIds) {
        return itemManager.getItems(itemsIds);
    }

    @Override
    public Button getCustomButton(String iconId) {
        return configManager.getIcon(iconId);
    }

    @Override
    public FunctionSet getCustomFunction(String functionId) {
        return configManager.getFunction(functionId);
    }

    @Override
    public Animation getAnimation(String animationId) {
        return animationManager.getAnimation(animationId);
    }

    @Override
    public Message getMessage(String messageId) {
        return messageManager.getMessage(messageId);
    }

    @Override
    public MenuFactory getMenuFactory(String type) {
        return factoryManager.getMenuFactory(type);
    }

    @Override
    public MessageFactory getMessageFactory(String type) {
        return null;
    }

    @Override
    public PlayerFactory getPlayerFactory() {
        return null;
    }

    @Override
    public FunctionFactory getFunctionFactory(String factoryId) {
        return factoryManager.getFunctionFactory(factoryId);
    }

    @Override
    public ConditionFactory getConditionFactory(String factoryId) {
        return factoryManager.getConditionFactory(factoryId);
    }

    @Override
    public ActionFactory getActionFactory(String factoryId) {
        return factoryManager.getActionFactory(factoryId);
    }

}
