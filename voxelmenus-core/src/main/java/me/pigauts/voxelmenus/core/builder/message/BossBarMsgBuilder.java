package me.pigauts.voxelmenus.core.builder.message;

import me.pigauts.voxelmenus.message.type.BossBarMessage;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

import java.util.ArrayList;
import java.util.List;

public class BossBarMsgBuilder {
    private String title;
    private BarStyle style;
    private BarColor color;
    private int duration;
    private int frequency;
    private float startProgress;
    private final List<Float> progression = new ArrayList<>();

    public BossBarMsgBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BossBarMsgBuilder setColor(BarColor color) {
        this.color = color;
        return this;
    }

    public BossBarMsgBuilder setStyle(BarStyle style) {
        this.style = style;
        return this;
    }

    public BossBarMsgBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public BossBarMsgBuilder setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public BossBarMsgBuilder setStartProgress(float startProgress) {
        this.startProgress = startProgress;
        return this;
    }

    public BossBarMsgBuilder addProgression(float progression) {
        this.progression.add(progression);
        return this;
    }

    public BossBarMessage build() {
        return new BossBarMessage(title, style, color, duration, frequency, startProgress, progression);
    }
}
