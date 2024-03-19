package me.pigauts.voxelmenus.core.builder;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuAction;
import me.pigauts.voxelmenus.core.collection.IdMap;
import me.pigauts.voxelmenus.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.type.StaticMenu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.util.MenuLayout;
import org.apache.commons.lang.Validate;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class StaticMenuBuilder extends MenuBuilder<StaticMenu> {

    protected String title = "NOT SET";
    protected Button[] buttons;
    protected final IdMap<Function> functions = new IdMapImpl<>();

    public StaticMenuBuilder(String name) {
        super(name);
        this.buttons = new Button[size];
    }

    public StaticMenuBuilder(String name, InventoryType storage) {
        super(name, storage);
        this.buttons = new Button[size];
    }

    public StaticMenuBuilder(String name, InventoryType storage, String title) {
        this(name, storage);
        this.setTitle(title);
    }

    public StaticMenuBuilder(@NotNull ConfigSection config) {
        super(config);
        title = config.getNotNull(config::getColorString, "title");
        buttons = config.getAtKey(MenuLayout::fromConfig, "layout").apply(this);
        for (String menuAction : MenuAction.values()) {
            if (!config.isSet(menuAction)) continue;
            functions.put(menuAction, config.getAtSection(FunctionSet::fromConfig, menuAction));
        }
    }

    @Override
    public StaticMenu build() {
        return new StaticMenu(name, getSettings(), getMeta());
    }

    public MenuMeta getMeta() {
        return new MenuMeta(title, buttons, functions);
    }

    @Override
    public MenuBuilder setSize(int size) {
        super.setSize(size);
        this.buttons = Arrays.copyOf(buttons, size);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public StaticMenuBuilder setTitle(@NotNull String title) {
        Validate.notNull(title, "Title cannot be null");
        this.title = title;
        return this;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public void setButton(int index, Button button) {
        if (index < 0 || index >= buttons.length) return;
        buttons[index] = button;
    }

    public StaticMenuBuilder setButtons(@NotNull Button[] buttons) {
        Validate.notNull(buttons, "Buttons cannot be null");
        Validate.isTrue(buttons.length == size, "Buttons do not match the size of inventory");
        this.buttons = buttons;
        return this;
    }

}
