package me.pigauts.voxelmenus.core.builder.function;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Condition;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.function.ConditionalFunction;
import me.pigauts.voxelmenus.function.LoopedFunction;
import me.pigauts.voxelmenus.function.action.ActionSet;
import me.pigauts.voxelmenus.function.condition.ConditionSet;
import me.pigauts.voxelmenus.util.FactoryUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ConditionalFunctionBuilder extends FunctionBuilder {

    private final List<Condition> conditions;
    private final List<Action> success;
    private final List<Action> failure;

    public ConditionalFunctionBuilder() {
        conditions = new ArrayList<>();
        success = new ArrayList<>();
        failure = new ArrayList<>();
    }

    public ConditionalFunctionBuilder(@NotNull Config config) {
        super(config);
        conditions = config.getList(FactoryUtil::createCondition, "if");
        success = config.getList(FactoryUtil::createAction, "do");
        failure = config.getList(FactoryUtil::createAction, "else");
    }

    public ConditionalFunctionBuilder addCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }

    public ConditionalFunctionBuilder addSuccessAction(Action action) {
        success.add(action);
        return this;
    }

    public ConditionalFunctionBuilder addFailureAction(Action action) {
        failure.add(action);
        return this;
    }

    @Override
    public Function build() {
        Function function = new ConditionalFunction(new ConditionSet(conditions), new ActionSet(success), new ActionSet(failure));
        return repetitions < 1 ? function : new LoopedFunction(function, repetitions);
    }

}
