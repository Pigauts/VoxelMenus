package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.message.Message;
import me.pigauts.voxelmenus.API.MenuPlayer;
import org.jetbrains.annotations.Nullable;

public class ChatMessage implements Message {

    private final String message;

    public ChatMessage(String message) {
        this.message = message;
    }

    @Nullable
    public static ChatMessage fromConfig(Config config) {
        if (config == null) return null;
        return new ChatMessage(config.getNotNull(config::getColorString, "message"));
    }

    @Override
    public void send(MenuPlayer player) {
        player.sendMessage(message);
    }
    
}
