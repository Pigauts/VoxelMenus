package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.message.Message;
import me.pigauts.voxelmenus.API.MenuPlayer;

import java.util.List;

public class MessageSequence implements Message {

    private final List<Message> messages;

    public MessageSequence(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public void send(MenuPlayer user) {
        for (Message message : messages)
            message.send(user);
    }

}
