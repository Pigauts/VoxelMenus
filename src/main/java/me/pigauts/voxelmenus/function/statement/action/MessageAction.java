package me.pigauts.voxelmenus.function.statement.action;

import me.pigauts.voxelmenus.effect.message.Message;
import me.pigauts.voxelmenus.user.MenuPlayer;

public class MessageAction implements Action {

    private final Message message;

    public MessageAction(Message message) {
        this.message = message;
    }

    @Override
    public void execute(MenuPlayer player) {
        message.send(player);
    }

}
