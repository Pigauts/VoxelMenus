package me.pigauts.voxelmenus.core.factory;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.factory.*;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class FactoryManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, MenuFactory> menuFactories = DefaultFactories.getMenuFactories();
    private final Map<String, MessageFactory> messageFactories = DefaultFactories.getMessageFactories();
    private final Map<String, FunctionFactory> functionFactories = DefaultFactories.getFunctionFactories();
    private final Map<String, ActionFactory> actionFactories = DefaultFactories.getActionFactories();
    private final Map<String, ConditionFactory> conditionFactories = DefaultFactories.getConditionFactories();
    private final Map<String, EntriesFactory> entriesFactories = DefaultFactories.getMenuEntriesFactory();

    private PlayerFactory playerFactory = DefaultFactories.getPlayerFactory();

    public FactoryManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public MenuFactory getMenuFactory(String factoryId) {
        return menuFactories.get(factoryId);
    }

    public MessageFactory getMessageFactory(String factoryId) {
        return messageFactories.get(factoryId);
    }

    public ActionFactory getActionFactory(String factoryId) {
        return actionFactories.get(factoryId);
    }

    public ConditionFactory getConditionFactory(String factoryId) {
        return conditionFactories.get(factoryId);
    }

    public EntriesFactory getEntriesFactory(String factoryId) {
        return entriesFactories.get(factoryId);
    }

    public FunctionFactory getFunctionFactory(String factoryId) {
        return functionFactories.get(factoryId);
    }

    public void registerMenuFactory(String factoryId, MenuFactory menuFactory) {
        menuFactories.put(factoryId, menuFactory);
    }

    public void registerMessageFactory(@NotNull String factoryId, @NotNull MessageFactory messageFactory) {
        messageFactories.put(factoryId, messageFactory);
    }

    public void registerActionFactory(@NotNull String factoryId, @NotNull ActionFactory actionFactory) {
        actionFactories.put(factoryId, actionFactory);
    }

    public void registerConditionFactory(@NotNull String id, @NotNull ConditionFactory conditionFactory) {
        conditionFactories.put(id, conditionFactory);
    }

    public void registerFunctionFactory(@NotNull String factoryId, @NotNull FunctionFactory functionFactory) {
        functionFactories.put(factoryId, functionFactory);
    }

    public void setPlayerFactory(@NotNull PlayerFactory playerFactory) {
        if (playerFactory == null) return;
        this.playerFactory = playerFactory;
    }

}
