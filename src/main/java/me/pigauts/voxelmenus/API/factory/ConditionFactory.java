package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.factory.Factory;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import me.pigauts.voxelmenus.core.holder.ValueHolder;

@FunctionalInterface
public interface ConditionFactory extends Factory<ValueHolder, Condition> {

    @Override
    Condition create(ValueHolder value);

}
