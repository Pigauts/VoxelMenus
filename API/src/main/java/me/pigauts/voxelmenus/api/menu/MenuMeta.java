package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.api.core.collection.IdMap;
import me.pigauts.voxelmenus.api.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.button.SimpleTemplateButton;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;

public class MenuMeta {

    public static final MenuMeta EMPTY_META = new MenuMeta("", new SimpleTemplateButton[0]);

    private String title;
    private final TemplateButton[] buttons;
    private final IdMap<Function> functions;

    public MenuMeta(String title, TemplateButton[] buttons) {
        this(title, buttons, new IdMapImpl<>());
    }

    public MenuMeta(String title, TemplateButton[] buttons, IdMap<Function> functions) {
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

    public TemplateButton[] getButtons() {
        return buttons;
    }

    public TemplateButton getButton(int index) {
        if (index < 0 || index > buttons.length) return null;
        return buttons[index];
    }

    public void setButton(int slot, TemplateButton button) {
        if (slot < 0 || slot > buttons.length) return;
        buttons[slot] = button;
    }

    public void setButton(TemplateButton button, int... slots) {
        for (int slot : slots) {
            setButton(slot, button);
        }
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

