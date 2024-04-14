package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;

import java.util.List;

public class SequenceMessage implements Message {

    private final List<Message> messages;

    public SequenceMessage(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void send(MenuPlayer user) {
        for (Message message : messages)
            message.send(user);
    }

}
