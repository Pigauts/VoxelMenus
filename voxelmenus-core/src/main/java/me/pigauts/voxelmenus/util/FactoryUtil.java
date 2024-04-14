package me.pigauts.voxelmenus.util;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.event.config.ActionLoadEvent;
import me.pigauts.voxelmenus.api.event.config.ConditionLoadEvent;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.function.Condition;

public class FactoryUtil {

    private static final VoxelMenusPlugin plugin = new VoxelMenusPlugin();

    public static Condition createCondition(Config config) {
        ConditionLoadEvent event = new ConditionLoadEvent(config, plugin.getConditionFactory(config.getKey()));
        Utils.callEvent(event);
        return event.getResult();
    }

    public static Action createAction(Config config) {
        ActionLoadEvent event = new ActionLoadEvent(config, plugin.getActionFactory(config.getKey()));
        Utils.callEvent(event);
        return event.getResult();
    }

}
