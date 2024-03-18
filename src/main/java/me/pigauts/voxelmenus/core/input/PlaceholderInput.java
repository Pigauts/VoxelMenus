package me.pigauts.voxelmenus.core.input;

import me.pigauts.voxelmenus.core.holder.Placeholder;

public class PlaceholderInput extends InputAdapter<Placeholder> implements InputReceiver<String> {

    private final String name;

    private PlaceholderInput(ArgumentInput argument, InputReceiver<Placeholder> receiver) {
        super(argument.input(), receiver);
        this.name = argument.name();
    }

    public static void collect(ArgumentInput argument, InputReceiver<Placeholder> receiver) {
        if (argument == null || receiver == null) return;
        new PlaceholderInput(argument, receiver).collect();
    }

    @Override
    public void collect() {
        input.collect(this);
    }

    @Override
    public void receiveInput(String input) {
        receiver.receiveInput(new Placeholder(name, input));
    }

}
