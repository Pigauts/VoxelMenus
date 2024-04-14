package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.core.factory.Factories;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class FunctionSet implements Function {

    private final Function[] functions;

    public FunctionSet(Collection<Function> functions) {
        this.functions = Util.toNotNullArray(functions, new Function[0]);
    }

    @Nullable
    public static FunctionSet fromConfig(Config config) {
        if (config == null) return null;
        List<Function> functions = config.getList(Factories::createFunction);
        return functions.isEmpty() ? null : new FunctionSet(functions);
    }

    public void run(MenuPlayer player) {
        for (Function function : functions) {
            function.run(player);
        }
    }

}
