package me.pigauts.voxelmenus.core.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.function.action.ActionSet;

public class SimpleFunction implements Function {

    private final Action action;

    public SimpleFunction(Action action) {
        this.action = action;
    }

    public static SimpleFunction fromConfig(ConfigSection config) {
        if (config == null) return null;
        return new SimpleFunction(ActionSet.fromConfig(config));
    }

    @Override
    public void run(MenuPlayer player) {
        action.execute(player);
    }

}
