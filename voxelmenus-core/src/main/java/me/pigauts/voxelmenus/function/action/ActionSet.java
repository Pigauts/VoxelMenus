package me.pigauts.voxelmenus.function.action;

import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.util.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ActionSet implements Action {

    private final Action[] actions;

    public ActionSet(@NotNull Collection<Action> actions) {
        this.actions = Utils.toNotNullArray(actions, new Action[0]);
    }

    public static Action of(Collection<Action> actions) {
        if (actions == null || actions.isEmpty()) return Action.DEFAULT;
        return new ActionSet(actions);
    }

    @Override
    public void execute(MenuPlayer player) {
        for (Action action : actions) {
            action.execute(player);
        }
    }

}
