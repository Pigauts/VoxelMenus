package me.pigauts.voxelmenus.core.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.Factories;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FunctionSet implements Function {

    private final Function[] statements;

    public FunctionSet(Collection<Function> statements) {
        this.statements = Util.toNotNullArray(statements, new Function[0]);
    }

    @Nullable
    public static FunctionSet fromConfig(Config config) {
        if (config == null) return null;
        List<Function> statements = new ArrayList<>();

        for (Config subSection : config.getSections()) {
            Function statement = Factories.createFunction(subSection);
            if (statement != null) {
                statements.add(statement);
            }
        }

        return statements.isEmpty() ? null : new FunctionSet(statements);
    }

    public void run(MenuPlayer user) {
        for (Function statement : statements) {
            statement.run(user);
        }
    }

}
