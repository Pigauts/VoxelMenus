package me.pigauts.voxelmenus.api.factory;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.message.Message;

@FunctionalInterface
public interface MessageFactory extends ConfigFactory<Message> {

    @Override
    Message create(Config config);

}
