package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class SendChatMessage implements Action {

    private final String message;

    public SendChatMessage(String message) {
        this.message = message;
    }

    @Override
    public void execute(MenuPlayer player) {
        player.sendMessage(message);
    }

}
