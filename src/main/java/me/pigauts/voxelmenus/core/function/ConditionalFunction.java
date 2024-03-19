package me.pigauts.voxelmenus.core.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.function.action.ActionSet;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.function.condition.ConditionSet;

public class ConditionalFunction implements Function {

    private final Condition condition;
    private final Action success;
    private final Action failure;

    public ConditionalFunction(Condition condition, Action success, Action failure) {
        this.condition = condition;
        this.success = success;
        this.failure = failure;
    }

    public static ConditionalFunction fromConfig(Config config) {
        if (config == null) return null;

        return new ConditionalFunction(
                config.getAtSection(ConditionSet::fromConfig, "if"),
                config.getAtSection(ActionSet::fromConfig, "do"),
                config.getAtSection(ActionSet::fromConfig, "else")
        );
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
