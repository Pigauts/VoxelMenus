package me.pigauts.voxelmenus.core.input;

public abstract class InputAdapter<T> {

    protected final PlayerInput input;
    protected final InputReceiver<T> receiver;

    public InputAdapter(PlayerInput input, InputReceiver<T> receiver) {
        this.input = input;
        this.receiver = receiver;
    }

    public abstract void collect();

    public PlayerInput getInput() {
        return input;
    }

    public InputReceiver<T> getReceiver() {
        return receiver;
    }

}
