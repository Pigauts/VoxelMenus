package me.pigauts.voxelmenus.api.core;

import me.pigauts.voxelmenus.core.builder.menu.MenuBuilder;
import me.pigauts.voxelmenus.api.config.Config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuLayout implements Iterable<String> {

    private final List<String> keys = new ArrayList<>();

    public static MenuLayout fromConfig(Config config) {
        if (config == null) return null;
        MenuLayout layout = new MenuLayout();

        for (String row : config.getStringList()) {
            for (String key : row.split(" ")) {
                if (Utils.NULL_CHARACTERS.contains(key)) {
                    layout.add(null);
                    continue;
                }
                layout.add(key);
            }
        }

        return layout;
    }

    public List<String> get() {
        return keys;
    }

    public String get(int index) {
        return keys.get(index);
    }

    public void add(String value) {
        if (keys.size() >= keys.size()) return;
        keys.add(value);
    }

    public void set(int index, String value) {
        if (index < 0 || index >= keys.size()) return;
        keys.set(index, value);
    }

    public Button[] apply(MenuBuilder builder) {
        int size = builder.getSize();
        Button[] icons = new Button[size];

        for (int i = 0; i < size; i++) {
            icons[i] = i >= keys.size() ? null : builder.getCustomButton(keys.get(i));
        }

        return icons;
    }

    @Override
    public Iterator<String> iterator() {
        return keys.iterator();
    }

}
