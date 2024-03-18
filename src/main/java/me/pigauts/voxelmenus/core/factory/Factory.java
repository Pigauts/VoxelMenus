package me.pigauts.voxelmenus.core.factory;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Factory<T, R> {

    @NotNull R create(T t);

}
