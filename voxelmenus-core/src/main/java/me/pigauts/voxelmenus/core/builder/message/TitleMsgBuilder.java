package me.pigauts.voxelmenus.core.builder.message;

import me.pigauts.voxelmenus.message.type.TitleMessage;
import org.bukkit.ChatColor;

public class TitleMsgBuilder {

    private String title = ChatColor.RESET.toString();
    private String subtitle = ChatColor.RESET.toString();
    private int fadeIn = 0;
    private int stay = 0;
    private int fadeOut = 0;

    public TitleMsgBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TitleMsgBuilder setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public TitleMsgBuilder setFadeIn(int fadeIn) {
        this.fadeIn = fadeIn;
        return this;
    }

    public TitleMsgBuilder setStay(int stay) {
        this.stay = stay;
        return this;
    }

    public TitleMsgBuilder setFadeOut(int fadeOut) {
        this.fadeOut = fadeOut;
        return this;
    }

    public TitleMessage build() {
        return new TitleMessage(title, subtitle, fadeIn, stay, fadeOut);
    }

}
