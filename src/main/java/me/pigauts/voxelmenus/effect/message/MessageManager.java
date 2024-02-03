package me.pigauts.voxelmenus.effect.message;

import me.pigauts.voxelmenus.VoxelMenusPlugin;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, Message> messagesByName = new HashMap<>();

    public MessageManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public Message getMessage(String name) {
        return messagesByName.get(name);
    }

    public void load() {

    }

}
