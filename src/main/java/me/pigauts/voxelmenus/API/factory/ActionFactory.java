package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.factory.Factory;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.holder.ValueHolder;

@FunctionalInterface
public interface ActionFactory extends Factory<ValueHolder, Action> {

    @Override
    Action create(ValueHolder holder);

}


