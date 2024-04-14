package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.holder.Placeholder;
import me.pigauts.voxelmenus.core.input.ArgumentInput;
import me.pigauts.voxelmenus.core.input.InputReceiver;
import me.pigauts.voxelmenus.core.input.PlaceholderInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InputFunction implements Function, InputReceiver<Placeholder> {

    private final Queue<ArgumentInput> arguments = new LinkedList<>();
    private final List<Placeholder> placeholders = new ArrayList<>();
    private final Function function;

    public InputFunction(Function function) {
        this.function = function;
    }

    @Override
    public void run(MenuPlayer player) {
        PlaceholderInput.collect(arguments.poll(), this);
    }

    public void receiveInput(Placeholder placeholder) {
        placeholders.add(placeholder);

        if (arguments.size() > 0) {
            PlaceholderInput.collect(arguments.poll(), this);
            return;
        }

        function.run(null);

    }

}
