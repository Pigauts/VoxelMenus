package me.pigauts.voxelmenus.effect.message.type;

import me.pigauts.voxelmenus.effect.message.Message;
import me.pigauts.voxelmenus.user.MenuPlayer;

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
