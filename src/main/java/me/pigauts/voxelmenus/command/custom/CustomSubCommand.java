package me.pigauts.voxelmenus.command.custom;

import me.pigauts.voxelmenus.command.subordinate.UserCommand;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.API.MenuPlayer;

import java.util.Arrays;

public class CustomSubCommand extends UserCommand {

    private final String[] args;
    private final FunctionSet function;

    public CustomSubCommand(String[] args, FunctionSet function) {
        this.args = args;
        this.function = function;
    }

    @Override
    public String getName() {
        return args[0];
    }

    @Override
    public int getMinArgs() {
        return args.length;
    }

    @Override
    public int getMaxArgs() {
        return args.length;
    }

    @Override
    public void execute(MenuPlayer user, String[] args) {
        if (!Arrays.equals(this.args, args)) return;
        function.run(user);
    }

}
