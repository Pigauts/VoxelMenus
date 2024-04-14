package me.pigauts.voxelmenus.message.type;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.message.Message;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.core.runnable.MenusRunnable;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class BossBarMessage implements Message {

	private final String title;
	
	private final BarColor color;
	private final BarStyle style;
	
	private final int duration;
	private final int frequency;
	private final float startProgress;
	
	private final List<Float> progression;
	
	public BossBarMessage(String title, BarStyle style, BarColor color, int duration, int frequency, float startProgress, List<Float> progression) {
		this.title = title;
		this.color = color;
		this.style = style;
		this.duration = duration;
		this.frequency = frequency;
		this.startProgress = startProgress;
		this.progression = progression;
		if (progression.isEmpty()) {
			int repetitions = duration / frequency;
			float decrement = -(1.0f / repetitions);
			for (int i = 0; i < repetitions; i++) {
				progression.add(-decrement);
			}
		}
	}

	public BossBarMessage(String title, BarStyle style, BarColor color, int duration) {
        this.title = title;
        this.color = color;
        this.style = style;
        this.duration = duration;
		this.frequency = duration/10;
		this.startProgress = 1.0f;
		this.progression = Arrays.asList(-0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f, -0.1f);
    }

	@Nullable
	public static BossBarMessage fromConfig(Config config) {
		if (config == null) return null;
		return new BossBarMessage(
				config.getString("title", "Not set"),
				config.getBarStyle("style", BarStyle.SEGMENTED_6),
				config.getBarColor("color", BarColor.RED),
				config.getInt("duration", 200),
				config.getInt("frequency", 10),
				config.getFloat("starting-progress", 1.0f),
				config.getFloatList("progression")
		);
	}

	public void send(MenuPlayer player) {
		BossBar bossBar = Bukkit.getServer().createBossBar(title, color, style);
		
		bossBar.setProgress(startProgress);
		bossBar.addPlayer(player.asPlayer());

		new MenusRunnable() {
			int loop = 0;

			@Override
			public void run() {
				if (loop >= duration) {
					bossBar.removeAll();
					cancel();
					return;
				}

				bossBar.setProgress(bossBar.getProgress() + progression.get(loop));
				loop++;
			}
		}.runTaskTimer(frequency);

	}

}
