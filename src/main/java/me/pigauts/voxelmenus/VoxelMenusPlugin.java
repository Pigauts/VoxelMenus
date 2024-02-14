package me.pigauts.voxelmenus;

import me.pigauts.voxelmenus.command.CommandManager;
import me.pigauts.voxelmenus.command.menu.MenusCommand;
import me.pigauts.voxelmenus.config.FactoryManager;
import me.pigauts.voxelmenus.effect.animation.AnimationManager;
import me.pigauts.voxelmenus.effect.message.MessageManager;
import me.pigauts.voxelmenus.item.ItemManager;
import me.pigauts.voxelmenus.listener.InventoryEventsListener;
import me.pigauts.voxelmenus.listener.PlayerJoinQuitListener;
import me.pigauts.voxelmenus.menu.MenuManager;
import me.pigauts.voxelmenus.player.MenuPlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class VoxelMenusPlugin extends JavaPlugin implements VoxelPlugin {

    private final MenuPlayerManager userManager = new MenuPlayerManager(this);
    private final MenuManager menuManager = new MenuManager(this);
    private final ItemManager itemManager = new ItemManager(this);
    private final AnimationManager animationManager = new AnimationManager(this);
    private final MessageManager messageManager = new MessageManager(this);
    private final CommandManager commandManager = new CommandManager(this);
    private final FactoryManager factoryManager = new FactoryManager(this);

    private static VoxelMenusPlugin plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {

        createPluginFolder();
        createFolder("items");
        createFolder("menus");
        createFolder("messages");
        createFolder("placeholders");
        createFolder("triggers");

        saveDefaultFile("menus", "ExampleStatic.yml");
        saveDefaultFile("menus", "ExampleDynamic.yml");
        saveDefaultFile("menus", "ExamplePaged.yml");
        saveDefaultFile("menus", "ExampleAtlas.yml");
        saveDefaultFile("menus", "ExampleFull.yml");

        registerEvents(new PlayerJoinQuitListener(this));
        registerEvents(new InventoryEventsListener(this));

        itemManager.load();
        menuManager.load();
        animationManager.load();

        commandManager.addCommand(new MenusCommand());
        commandManager.registerAll();

        userManager.load();

    }

    @Override
    public void onDisable() {

    }


    public static VoxelMenusPlugin getPlugin() {
        return plugin;
    }

    public MenuPlayerManager getPlayers() {
        return userManager;
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

    public FactoryManager getFactory() {
        return factoryManager;
    }

}
