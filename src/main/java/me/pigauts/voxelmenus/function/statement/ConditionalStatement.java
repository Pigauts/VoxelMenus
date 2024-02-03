package me.pigauts.voxelmenus.function.statement;

import me.pigauts.voxelmenus.function.statement.Statement;
import me.pigauts.voxelmenus.function.statement.action.Action;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.user.MenuPlayer;

import java.util.Set;

public class ConditionalStatement implements Statement {

    private final Set<Condition> conditions;
    private final Set<Action> success;
    private final Set<Action> failure;

    public ConditionalStatement(Set<Condition> conditions, Set<Action> success, Set<Action> failure) {
        this.conditions = conditions;
        this.success = success;
        this.failure = failure;
    }

    @Override
    public void perform(MenuPlayer user) {

        for (Condition condition : conditions)
            if (!condition.isMet(user)) {
                for (Action action : failure)
                    action.execute(user);
                return;
            }

        for (Action action : success)
            action.execute(user);

    }

}
