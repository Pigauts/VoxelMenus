package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.DynamicButtons;
import me.pigauts.voxelmenus.menu.button.Button;
import me.pigauts.voxelmenus.user.MenuPlayer;

import java.util.Map;

public class DynamicMenu extends SimpleMenu {

    private final Map<String, DynamicButtons> buttonsByName;

    public DynamicMenu(String name, String title, int size, int refreshTicks, Function openFunction, Function closeFunction, Map<String, DynamicButtons> buttonsByName) {
        super(name, title, size, refreshTicks, openFunction, closeFunction);
        this.buttonsByName = buttonsByName;
    }

    @Override
    public Button[] getButtons(MenuPlayer player) {
        for (DynamicButtons buttons : buttonsByName.values()) {
            if (buttons.condition().isMet(player))
                return buttons.buttons();
        }

        return buttonsByName.get("default").buttons();
    }

    @Override
    public Button[] getButtonsByName(MenuPlayer player, String name) {
        return buttonsByName.get(name).buttons();
    }

}
