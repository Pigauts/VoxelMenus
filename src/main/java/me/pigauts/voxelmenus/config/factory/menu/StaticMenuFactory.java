package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.button.Button;
import me.pigauts.voxelmenus.menu.type.StaticMenu;

import java.util.List;
import java.util.Map;

public class StaticMenuFactory extends SimpleMenuFactory {

    @Override
    public Menu createMenu(Config config) {

        Map<String, Button> customButtons = createCustomButtons(config);
        List<String> layout = config.getLayout("layout");

        int size = createSize(config);
        Button[] buttons = new Button[size];

        for (int i = 0; i < size; i++) {
            if (layout.size() < size) continue;
            buttons[i] = customButtons.get(layout.get(i));
        }

        return new StaticMenu(
                createName(config),
                createTitle(config),
                size,
                createRefresh(config),
                createOpenFunction(config),
                createCloseFunction(config),
                buttons);
    }

}
