package me.pigauts.voxelmenus.core.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.config.Config;

public class LoopedFunction implements Function {

    private final Function function;
    private final int repetitions;

    public LoopedFunction(Function function, int repetitions) {
        this.function = function;
        this.repetitions = repetitions;
    }

    @Override
    public void run(MenuPlayer player) {
        for (int i = 0; i < repetitions; i++) {
            function.run(player);
        }
    }

    public static Function fromConfig(Config config) {
        if (config == null) return null;
        return new LoopedFunction(SimpleFunction.fromConfig(config), config.getInt("repetitions"));
    }


}
