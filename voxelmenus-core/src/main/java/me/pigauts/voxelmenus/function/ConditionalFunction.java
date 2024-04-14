package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Condition;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public class ConditionalFunction implements Function {

    private final Condition condition;
    private final Action success;
    private final Action failure;

    public ConditionalFunction(Condition condition, Action success, Action failure) {
        this.condition = condition;
        this.success = success;
        this.failure = failure;
    }

    @Override
    public void run(MenuPlayer player) {
        if (condition.isMet(player)) {
            success.execute(player);
            return;
        }

        failure.execute(player);
    }

}
