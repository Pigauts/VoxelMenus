package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

public class ChatMessage implements Message {

    private final String message;

    public ChatMessage(String message) {
        this.message = message;
    }

    @Override
    public void send(MenuPlayer player) {
        player.sendMessage(message);
    }
    
}
