package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.core.placeholder.*;
import me.pigauts.voxelmenus.api.function.*;
import me.pigauts.voxelmenus.api.player.*;

import java.util.*;

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
