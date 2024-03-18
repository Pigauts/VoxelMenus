package me.pigauts.voxelmenus.core.factory;

@FunctionalInterface
public interface BiFactory<T, U, R> {

    R create(T t, U u);

}
