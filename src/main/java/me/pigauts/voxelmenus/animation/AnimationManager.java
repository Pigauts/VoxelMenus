package me.pigauts.voxelmenus.animation;

import me.pigauts.voxelmenus.VoxelMenusPlugin;

import java.util.HashMap;
import java.util.Map;

public class AnimationManager {

    private final VoxelMenusPlugin plugin;

    private final Map<String, Animation> animationsByName = new HashMap<>();

    public AnimationManager(VoxelMenusPlugin plugin) {
        this.plugin = plugin;
    }

    public Animation getAnimation(String name) {
        return animationsByName.get(name);
    }

    public void load() {

    }
}
