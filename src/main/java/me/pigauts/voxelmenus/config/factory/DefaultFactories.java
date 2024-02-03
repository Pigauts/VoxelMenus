package me.pigauts.voxelmenus.config.factory;

import me.pigauts.voxelmenus.config.factory.menu.DynamicMenuFactory;
import me.pigauts.voxelmenus.config.factory.menu.MenuFactory;
import me.pigauts.voxelmenus.config.factory.menu.StaticMenuFactory;
import me.pigauts.voxelmenus.function.statement.Statement;
import me.pigauts.voxelmenus.function.statement.action.Action;
import me.pigauts.voxelmenus.function.statement.condition.Condition;

import java.util.HashMap;
import java.util.Map;

public class DefaultFactories {

    public static Map<String, MenuFactory> getMenuFactories() {
        Map<String, MenuFactory> menuFactories = new HashMap<>();

        menuFactories.put("static", new StaticMenuFactory());
        menuFactories.put("dynamic", new DynamicMenuFactory());

        return menuFactories;
    }

    public static StatementFactory getStatementFactory() {
        return new StatementFactory();
    }

    public static ActionFactory getActionFactory() {
        return new ActionFactory();
    }

    public static ConditionFactory getConditionFactory() {
        return new ConditionFactory();
    }


}
