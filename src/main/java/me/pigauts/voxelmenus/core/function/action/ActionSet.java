package me.pigauts.voxelmenus.core.function.action;

import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.Factories;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActionSet implements Action {

    private final Action[] actions;

    public ActionSet(Collection<Action> actions) {
        this.actions = Util.toNotNullArray(actions, new Action[0]);
    }

    @Nullable
    public static Action fromConfig(Config config) {
        if (config == null) return null;

        List<Action> actions = new ArrayList<>();

        for (String key : config.getKeys(false)) {
            Action action = Factories.createAction(config, key);
            if (action != null) {
                actions.add(action);
            }
        }

        return actions.isEmpty() ? Action.DEFAULT : new ActionSet(actions);
    }

    @Override
    public void execute(MenuPlayer player) {
        for (Action action : actions) {
            action.execute(player);
        }
    }

}
