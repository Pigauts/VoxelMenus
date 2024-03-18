package me.pigauts.voxelmenus.core.builder;

import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.function.FunctionSet;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.menu.type.StaticMenu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.util.MenuLayout;
import org.apache.commons.lang.Validate;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class StaticMenuBuilder extends MenuBuilder<StaticMenu> {

    protected String title = "NOT SET";
    protected FunctionSet openFunction;
    protected FunctionSet closeFunction;
    protected FunctionSet refreshFunction;
    protected Button[] buttons;

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

    public StaticMenuBuilder(@NotNull Config config) {
        super(config);
        title = config.getNotNull(config::getColorString, "title");
        openFunction = config.getAtSection(FunctionSet::fromConfig, "on-open");
        closeFunction = config.getAtSection(FunctionSet::fromConfig, "on-close");
        refreshFunction = config.getAtSection(FunctionSet::fromConfig, "on-refresh");
        buttons = config.getAtKey(MenuLayout::fromConfig, "layout").apply(this);
    }

    @Override
    public StaticMenu build() {
        MenuMeta meta = new MenuMetaImpl(title, buttons, new MenuFunctions(openFunction, closeFunction, refreshFunction));
        return new StaticMenu(name, getSettings(), meta);
    }

    public MenuMeta getMeta() {
        return new MenuMetaImpl(title, buttons, new MenuFunctions(openFunction, closeFunction, refreshFunction));
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

    @Nullable
    public FunctionSet getOpenFunction() {
        return openFunction;
    }

    public StaticMenuBuilder setOpenFunction(@Nullable FunctionSet openFunction) {
        this.openFunction = openFunction;
        return this;
    }

    @Nullable
    public FunctionSet getCloseFunction() {
        return closeFunction;
    }

    public StaticMenuBuilder setCloseFunction(@Nullable FunctionSet closeFunction) {
        this.closeFunction = closeFunction;
        return this;
    }

    @Nullable
    public FunctionSet getRefreshFunction() {
        return refreshFunction;
    }

    public StaticMenuBuilder setRefreshFunction(@Nullable FunctionSet refreshFunction) {
        this.refreshFunction = refreshFunction;
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
