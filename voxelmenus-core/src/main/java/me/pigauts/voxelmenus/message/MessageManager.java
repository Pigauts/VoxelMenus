package me.pigauts.voxelmenus.message;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.core.factory.Factories;

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
        for (Config config : plugin.getConfigs("messages")) {
            for (String key : config.getKeys(false)) {
                Message message = config.create(Factories::createMessage, key);
                if (message == null) continue;

                messagesByName.put(key, message);
            }

        }
    }

}
