package me.pigauts.voxelmenus.function;

import me.pigauts.voxelmenus.user.MenuPlayer;
import org.bukkit.event.inventory.ClickType;

import java.util.Map;

public class ClickFunction {

    private final Map<ClickType, Function> functionsByClick;

    public ClickFunction(Map<ClickType, Function> functions) {
        this.functionsByClick = functions;
    }

    public void run(MenuPlayer player, ClickType click) {
        Function function = functionsByClick.get(click);
        if (function != null) {
            function.run(player);
        }
    }
}
