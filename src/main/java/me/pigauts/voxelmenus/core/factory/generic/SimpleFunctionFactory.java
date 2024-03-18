package me.pigauts.voxelmenus.core.factory.generic;

import me.pigauts.voxelmenus.API.factory.FunctionFactory;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.Factories;
import me.pigauts.voxelmenus.core.function.ConditionalFunction;
import me.pigauts.voxelmenus.core.function.SimpleFunction;
import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.function.condition.Condition;

public class SimpleFunctionFactory implements FunctionFactory {

    @Override
    public Function create(Config config) {
        if (config == null) return null;

        String type = config.getString("type");

        if (type == null) {
            if (config.isSection("if") && config.isSection("do") || config.isSection("else")) {
                type = "conditional";
            } else {
                type = "simple";
            }
        }

        if (type.equalsIgnoreCase("simple")) {
            return SimpleFunction.fromConfig(config);

        } else if (type.equalsIgnoreCase("conditional")) {
            return ConditionalFunction.fromConfig(config);
        }

        return null;
    }

    protected ConditionalFunction getConditionalStatement(Config config) {
        Condition condition = Factories.createConditions(config.getSection("if"));
        Action success = Factories.createActions(config.getSection("do"));
        Action failure = Factories.createActions(config.getSection("else"));

        if (success == null) success = Action.DEFAULT;
        if (failure == null) failure = Action.DEFAULT;

        return new ConditionalFunction(condition, success, failure);
    }

}
