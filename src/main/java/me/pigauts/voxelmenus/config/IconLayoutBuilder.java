package me.pigauts.voxelmenus.config;

import me.pigauts.voxelmenus.menu.widget.Icon;

import java.util.List;
import java.util.Map;

public class IconLayoutBuilder {

    private final Map<String, Icon> customButtons;

    public IconLayoutBuilder(Map<String, Icon> customButtons) {
        this.customButtons = customButtons;
    }

    public Icon[] build(List<String> layout) {
        Icon[] buttons = new Icon[layout.size()];

        for (int i = 0; i < layout.size(); i++) {
            if (i < layout.size()) {
                buttons[i] = customButtons.get(layout.get(i));
                continue;
            }
            buttons[i] = null;
        }

        return buttons;
    }

}
