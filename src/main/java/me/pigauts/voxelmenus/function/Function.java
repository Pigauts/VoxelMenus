package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.Helper;
import me.pigauts.voxelmenus.function.statement.Statement;
import me.pigauts.voxelmenus.player.MenuPlayer;

import java.util.Collection;

public class Function {

    private final Statement[] statements;

    public Function(Collection<Statement> statements) {
        this.statements = Helper.toArray(statements);
    }

    public void run(MenuPlayer user) {
        for (Statement statement : statements)
            statement.perform(user);
    }

}
