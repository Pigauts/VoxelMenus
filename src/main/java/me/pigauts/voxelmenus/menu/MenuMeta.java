package me.pigauts.voxelmenus.menu;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.menu.widget.Entry;
import me.pigauts.voxelmenus.util.IdMap;

import java.util.HashMap;

public class MenuMeta {

    public static final MenuMeta EMPTY_META = new MenuMeta("", new Button[0]);

    private final String title;
    private final Button[] buttons;
    private final IdMap<Function> functions = new HashMap<String, Function>();

    public MenuMeta(String title, Button[] buttons) {
        this(title, buttons, new HashMap<String, Function>());
    }

    public MenuMeta(String title, Button[] buttons, IdMap<Function> functions) {
        this.title = title;
        this.buttons = buttons;
        this.functions = functions;
    }

    public String getTitle() {
        return title;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public Button getButton(int index) {
        if (index < 0 || index > buttons.length) return null;
        return buttons[index];
    }

    public void setButton(int index, Button button) {
        if (index < 0 || index > buttons.length) return;
        buttons[index] = button;
    }

    public void setEntry(int index, Entry entry) {
        Button button = getButton(index);
        if (button == null) {
            setButton(index, entry);
            return;
        }
        entry.apply(button);
    }

    public void clearButtons(int... slots) {
        for (int slot : slots) {
            if (slot < 0 || slot > buttons.length) continue;
            buttons[slot] = null;
        }
    }

    public Function getFunction(String id) {
        return functions.get(id);
    }

    public void setFunction(String id, Function function) {
        functions.put(id, function);
    }

    public MenuMeta clone() {
        return new MenuMeta(title, buttons.clone(), functions);
    }

}

