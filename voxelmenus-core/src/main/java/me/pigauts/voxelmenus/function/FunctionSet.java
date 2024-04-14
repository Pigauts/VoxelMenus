package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.util.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class FunctionSet implements Function {

    private final Function[] functions;

    public FunctionSet(@NotNull Collection<Function> functions) {
        this.functions = Utils.toNotNullArray(functions, new Function[0]);
    }

    public static Function of(Collection<Function> functions) {
        if (functions == null || functions.isEmpty()) return Function.DEFAULT;
        return new FunctionSet(functions);
    }

    public void run(MenuPlayer player) {
        for (Function function : functions) {
            function.run(player);
        }
    }

}
