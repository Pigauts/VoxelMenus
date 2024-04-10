package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.api.core.collection.IdMap;
import me.pigauts.voxelmenus.api.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.menu.widget.Entry;

public class MenuMeta {

    public static final MenuMeta EMPTY_META = new MenuMeta("", new Button[0]);

    private String title;
    private final Button[] buttons;
    private final IdMap<Function> functions;

    public MenuMeta(String title, Button[] buttons) {
        this(title, buttons, new IdMapImpl<>());
    }

    public MenuMeta(String title, Button[] buttons, IdMap<Function> functions) {
        this.title = title;
        this.buttons = buttons;
        this.functions = functions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public Button getButton(int index) {
        if (index < 0 || index > buttons.length) return null;
        return buttons[index];
    }

    public void setButton(int slot, Button button) {
        if (slot < 0 || slot > buttons.length) return;
        buttons[slot] = button;
    }

    public void setButton(Button button, int... slots) {
        for (int slot : slots) {
            setButton(slot, button);
        }
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

    public Function getFunction(String functionId) {
        return functions.get(functionId);
    }

    public void addFunction(String functionId, Function function) {
        functions.put(functionId, function);
    }

    public void removeFunction(String functionId) {
        functions.remove(functionId);
    }

    public MenuMeta clone() {
        return new MenuMeta(title, buttons.clone(), functions);
    }

}

