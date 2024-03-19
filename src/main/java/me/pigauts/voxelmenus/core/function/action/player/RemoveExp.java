package me.pigauts.voxelmenus.core.function.action.player;

import me.pigauts.voxelmenus.core.config.ConfigSection;

public class RemoveExp extends AddExp {

    public RemoveExp(int amount) {
        super(-amount);
    }

    public RemoveExp(ConfigSection config) {
        this(config.getInt("REMOVE_EXP"));
    }

}
