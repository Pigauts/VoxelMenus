package me.pigauts.voxelmenus.core.builder;

import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.factory.Factories;
import me.pigauts.voxelmenus.menu.type.PagedMenu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.menu.widget.entries.MenuEntries;
import me.pigauts.voxelmenus.util.MenuLayout;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PagedMenuBuilder extends StaticMenuBuilder {

    private MenuEntries entries;
    private int[] entrySlots;
    private Button template;

    public PagedMenuBuilder(@NotNull Config config) {
        super(config);
        entries = Factories.createEntries(config);

        MenuLayout layout = config.getAtKey(MenuLayout::fromConfig, "layout");
        List<Integer> slots = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (layout.get(i).equalsIgnoreCase("v")) {
                slots.add(i);
            }
        }
        entrySlots = slots.stream().mapToInt(Integer::intValue).toArray();
        template = config.getAtSection(Button::fromConfig, "template");
    }

    @Override
    public PagedMenu build() {
        return new PagedMenu(name, getSettings(), getMeta());
    }



}
