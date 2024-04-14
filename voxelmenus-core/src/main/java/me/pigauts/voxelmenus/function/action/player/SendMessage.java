package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;
import me.pigauts.voxelmenus.api.message.Message;

public class SendMessage implements Action {

    private final Message message;

    public SendMessage(Message message) {
        this.message = message;
    }

    @Override
    public void execute(MenuPlayer player) {
        message.send(player);
    }

}
