package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class SendMessage implements Action {

    private final me.pigauts.voxelmenus.message.Message message;

    public SendMessage(me.pigauts.voxelmenus.message.Message message) {
        this.message = message;
    }

    @Override
    public void execute(MenuPlayer player) {
        message.send(player);
    }

}
