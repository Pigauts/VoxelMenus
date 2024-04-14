package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.message.Title;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.core.runnable.MenusRunnable;

import java.util.List;

public class AnimatedTitleMessage implements Message {

    private final List<Title> frames;
    private final int frequency;

    public AnimatedTitleMessage(List<Title> frames, int frequency) {
        this.frames = frames;
        this.frequency = frequency;
    }

    @Override
    public void send(MenuPlayer player) {
        new MenusRunnable() {
            int loop = 0;
            int pause = 0;

            @Override
            public void run() {
                if (pause > 0) {
                    pause -= frequency;
                    return;
                }

                if (loop >= frames.size()) {
                    cancel();
                    return;
                }

                Title title = frames.get(loop);

                if (title.stay() > frequency) {
                    pause = title.stay();
                }

                player.sendTitle(title);
                loop++;
            }

        }.runTaskTimer(frequency);
    }

}
