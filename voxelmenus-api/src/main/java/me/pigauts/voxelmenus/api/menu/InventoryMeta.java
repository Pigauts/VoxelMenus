package me.pigauts.voxelmenus.api.menu;

import me.pigauts.voxelmenus.api.core.InventoryUtils;
import me.pigauts.voxelmenus.api.core.collection.IdMap;
import me.pigauts.voxelmenus.api.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.button.SimpleTemplateButton;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import org.bukkit.event.inventory.InventoryType;

import java.util.Arrays;

public class InventoryMeta {

    public static final InventoryMeta EMPTY_META = new InventoryMeta("", InventoryType.CHEST);

    private String title;
    private InventoryType storage;
    private int size;
    private TemplateButton[] templateButtons;
    private final IdMap<Function> functions = new IdMapImpl<>();

    public InventoryMeta(String title, InventoryType storage) {
        this(title, storage, storage.getDefaultSize(), new SimpleTemplateButton[storage.getDefaultSize()]);
    }

    public InventoryMeta(String title, InventoryType storage, TemplateButton[] buttons) {
        this(title, storage, storage.getDefaultSize(), buttons);
    }

    public InventoryMeta(String title, InventoryType storage, int size, TemplateButton[] templateButtons) {
        this.title = title;
        this.storage = storage;
        this.size = size;
        this.templateButtons = templateButtons;
    }

    public InventoryMeta(String title, InventoryType storage, int size, TemplateButton[] templateButtons, IdMap<Function> functions) {
        this(title, storage, size, templateButtons);
        this.functions.putAll(functions);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InventoryType getStorage() {
        return storage;
    }

    public void setStorage(InventoryType storage) {
        if (storage == null) return;
        this.storage = storage;
        setSize(storage.getDefaultSize());
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (InventoryUtils.isValidInventory(storage, size)) {
            this.size = size;
            this.templateButtons = Arrays.copyOf(templateButtons, size);
        }
    }

    public TemplateButton[] getTemplateButtons() {
        return templateButtons;
    }

    public TemplateButton getTemplateButton(int index) {
        if (index < 0 || index > templateButtons.length) return null;
        return templateButtons[index];
    }

    public void setButton(TemplateButton button, int slot) {
        if (slot < 0 || slot > templateButtons.length) return;
        templateButtons[slot] = button;
    }

    public void setButton(TemplateButton button, int... slots) {
        for (int slot : slots) {
            setButton(button, slot);
        }
    }

    public void clearButtons(int... slots) {
        for (int slot : slots) {
            if (slot < 0 || slot > templateButtons.length) continue;
            templateButtons[slot] = null;
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

    public InventoryMeta clone() {
        return new InventoryMeta(title, storage, size, templateButtons, functions);
    }

}

