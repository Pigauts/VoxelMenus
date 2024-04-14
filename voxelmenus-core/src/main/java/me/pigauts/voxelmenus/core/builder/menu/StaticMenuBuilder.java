package me.pigauts.voxelmenus.core.builder.menu;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.core.InventoryUtils;
import me.pigauts.voxelmenus.api.core.collection.IdMap;
import me.pigauts.voxelmenus.api.core.collection.IdMapImpl;
import me.pigauts.voxelmenus.api.core.enums.MenuFunction;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import me.pigauts.voxelmenus.function.FunctionSet;
import me.pigauts.voxelmenus.menu.type.StaticMenu;
import me.pigauts.voxelmenus.util.FactoryUtil;
import org.apache.commons.lang.Validate;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class StaticMenuBuilder extends MenuBuilder<StaticMenu> {

    protected static final List<String> NULL_CHARACTERS = Arrays.asList("n", "_");

    protected String title = "";
    protected TemplateButton[] buttons;
    protected final IdMap<Function> functions = new IdMapImpl<>();

    public StaticMenuBuilder(String name) {
        super(name);
        this.buttons = new TemplateButton[size];
    }

    public StaticMenuBuilder(String name, InventoryType storage) {
        super(name, storage);
        this.buttons = new TemplateButton[size];
    }

    public StaticMenuBuilder(String name, InventoryType storage, String title) {
        this(name, storage);
        this.setTitle(title);
    }

    public StaticMenuBuilder(@NotNull Config config) {
        super(config);
        title = config.getString("title");
        buttons = new TemplateButton[size];

        String[][] layout = config.get2DArray("layout");

        int index = 0;
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                if (NULL_CHARACTERS.contains(layout[i][j])) {
                    index++;
                    continue;
                }
                buttons[index++] = templateButtons.get(layout[i][j]);
            }
        }


        for (String function : MenuFunction.values()) {
            if (!config.isSet(function)) continue;
            functions.put(function, FunctionSet.of(config.getList(FactoryUtil::createFunction)));
        }
    }

    @Override
    public StaticMenu build() {
        return new StaticMenu(name, getSettings(), getInventoryMeta());
    }

    public InventoryMeta getInventoryMeta() {
        return new InventoryMeta(title, storage, size, buttons, functions);
    }

    @Override
    public MenuBuilder setSize(int size) {
        if (InventoryUtils.isValidInventory(storage, size)) {
            this.size = size;
            this.buttons = Arrays.copyOf(buttons, size);
        }
        return this;
    }

    public StaticMenuBuilder setTitle(@NotNull String title) {
        Validate.notNull(title, "Title cannot be null");
        this.title = title;
        return this;
    }

    public void setButton(int index, TemplateButton button) {
        if (index < 0 || index >= buttons.length) return;
        buttons[index] = button;
    }

}
