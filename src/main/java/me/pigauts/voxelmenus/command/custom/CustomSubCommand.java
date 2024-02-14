package me.pigauts.voxelmenus.command.custom;

import me.pigauts.voxelmenus.command.subordinate.UserCommand;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.player.MenuPlayer;

import java.util.Arrays;

public class CustomSubCommand extends UserCommand {

    private final String[] args;
    private final Function function;

    public CustomSubCommand(String[] args, Function function) {
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
