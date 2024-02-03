package me.pigauts.voxelmenus.function.statement;

import me.pigauts.voxelmenus.function.statement.action.Action;
import me.pigauts.voxelmenus.user.MenuPlayer;

import java.util.Set;

public class SimpleStatement implements Statement {

    private final Set<Action> actions;

    public SimpleStatement(Set<Action> actions) {
        this.actions = actions;
    }

    @Override
    public void perform(MenuPlayer user) {
        for (Action action : actions)
            action.execute(user);
    }

}
