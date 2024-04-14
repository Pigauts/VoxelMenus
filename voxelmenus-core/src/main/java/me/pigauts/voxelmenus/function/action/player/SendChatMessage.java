package me.pigauts.voxelmenus.function.action.player;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.api.function.Action;

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
