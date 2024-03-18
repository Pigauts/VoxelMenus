package me.pigauts.voxelmenus.core.function;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.core.function.condition.Condition;

import java.util.Collection;

public class SwitchFunction implements Function {

    public record SwitchEntry(Condition condition, Function function) { }

    private final SwitchEntry[] switchEntries;

    public SwitchFunction(Collection<SwitchEntry> switchEntries) {
        this.switchEntries = Util.toNotNullArray(switchEntries, new SwitchEntry[0]);
    }

    @Override
    public void run(MenuPlayer player) {
        for (SwitchEntry entry : switchEntries) {
            if (entry.condition.isMet(player)) {
                player.executeFunction(entry.function);
                return;
            }
        }
    }

}
