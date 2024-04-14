package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBarMessage implements Message {

    private final BaseComponent[] messages;

    public ActionBarMessage(String message) {
        this.messages = TextComponent.fromLegacyText(message);
    }

    @Override
    public void send(MenuPlayer player) {
        player.asPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, messages);
    }

}
