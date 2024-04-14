package me.pigauts.voxelmenus.core.builder.function;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.function.LoopedFunction;
import me.pigauts.voxelmenus.function.SimpleFunction;
import me.pigauts.voxelmenus.function.action.ActionSet;
import me.pigauts.voxelmenus.util.FactoryUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SimpleFunctionBuilder extends FunctionBuilder {

    private final List<Action> actions;

    public SimpleFunctionBuilder() {
        actions = new ArrayList<>();
    }

    public SimpleFunctionBuilder(@NotNull Config config) {
        super(config);
        actions = config.getList(FactoryUtil::createAction);
    }

    public SimpleFunctionBuilder addAction(Action action) {
        actions.add(action);
        return this;
    }

    @Override
    public Function build() {
        Function function = new SimpleFunction(new ActionSet(actions));
        return repetitions < 1 ? function : new LoopedFunction(function, repetitions);
    }

}
