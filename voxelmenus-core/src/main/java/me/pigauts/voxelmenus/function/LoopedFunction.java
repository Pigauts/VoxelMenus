package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

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

}
