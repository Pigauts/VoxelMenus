package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.message.Message;
import me.pigauts.voxelmenus.message.Title;
import me.pigauts.voxelmenus.API.MenuPlayer;

public class TitleMessage implements Message {

    private final Title title;

    public TitleMessage(Title title) {
        this.title = title;
    }

    public TitleMessage(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        this(new Title(title, subtitle, fadeIn, stay, fadeOut));
    }

    public static TitleMessage fromConfig(ConfigSection config) {
        if (config == null) return null;
        return new TitleMessage(Title.fromConfig(config));
    }

    @Override
    public void send(MenuPlayer player) {
        player.sendTitle(title);
    }

}
