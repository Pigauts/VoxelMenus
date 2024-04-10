package me.pigauts.voxelmenus.api.factory;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Factory<T, R> {

    @NotNull R create(T t);

}
