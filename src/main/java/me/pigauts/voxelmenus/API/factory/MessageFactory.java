package me.pigauts.voxelmenus.API.factory;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.ConfigFactory;
import me.pigauts.voxelmenus.message.Message;

@FunctionalInterface
public interface MessageFactory extends ConfigFactory<Message> {

    @Override
    Message create(Config config);

}
