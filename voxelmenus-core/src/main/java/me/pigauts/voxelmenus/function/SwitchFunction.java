package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.util.Utils;

import java.util.Collection;

public class SwitchFunction implements Function {

    private final SwitchCase[] switchCases;

    public SwitchFunction(Collection<SwitchCase> switchEntries) {
        this.switchCases = Utils.toNotNullArray(switchEntries, new SwitchCase[0]);
    }

    @Override
    public void run(MenuPlayer player) {
        for (SwitchCase switchCase : switchCases) {
            if (switchCase.condition().isMet(player)) {
                switchCase.action().execute(player);
                if (switchCase.breakCycle()) return;
            }
        }

        switchCases[switchCases.length - 1].action().execute(player);
    }

}
