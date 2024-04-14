package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class JsonMessage implements Message {

    private final BaseComponent[] components;

    public JsonMessage(String rawMessage) {
        this.components = TextComponent.fromLegacyText(rawMessage);
    }

    @Override
    public void send(MenuPlayer player) {
        player.asPlayer().spigot().sendMessage(components);
    }

}
