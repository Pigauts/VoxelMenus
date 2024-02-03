package me.pigauts.voxelmenus.config;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.config.factory.*;
import me.pigauts.voxelmenus.config.factory.menu.MenuFactory;
import me.pigauts.voxelmenus.function.statement.Statement;
import me.pigauts.voxelmenus.function.statement.action.Action;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.menu.Menu;

import java.util.Map;

public class FactoryManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, MenuFactory> menuFactories = DefaultFactories.getMenuFactories();

    private StatementFactory statementFactory = DefaultFactories.getStatementFactory();
    private ConditionFactory conditionFactory = DefaultFactories.getConditionFactory();
    private ActionFactory actionFactory = DefaultFactories.getActionFactory();

    public FactoryManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }


    public void registerMenuFactory(String id, MenuFactory menuFactory) {
        if (menuFactory == null) return;
        menuFactories.put(id, menuFactory);
    }

    public void registerStatementFactory(StatementFactory statementFactory) {
        if (statementFactory == null) return;
        this.statementFactory = statementFactory;
    }

    public void registerConditionFactory(ConditionFactory conditionFactory) {
        if (conditionFactory == null) return;
        this.conditionFactory = conditionFactory;
    }

    public void registerActionFactory(ActionFactory actionFactory) {
        if (actionFactory == null) return;
        this.actionFactory = actionFactory;
    }

    public Menu createMenu(Config config) {
        String type = config.getString("type");

        MenuFactory factory = menuFactories.get(type);

        if (factory == null) return null;

        return factory.createMenu(config);
    }

    public Statement createStatement(Config section) {
        return statementFactory.createStatement(section);
    }

    public Action createAction(String key, Object value) {
        return actionFactory.createAction(key, value);
    }

    public Condition createCondition(String key, Object value) {
        return conditionFactory.createCondition(key, value);
    }


}
