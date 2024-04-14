package me.pigauts.voxelmenus.core.builder.menu;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.animation.Animation;
import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.core.InventoryUtils;
import me.pigauts.voxelmenus.api.menu.Menu;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import me.pigauts.voxelmenus.core.builder.Builder;
import me.pigauts.voxelmenus.core.builder.ButtonBuilder;
import me.pigauts.voxelmenus.menu.MenuSettings;
import org.apache.commons.lang.Validate;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class MenuBuilder<T extends Menu> extends Builder<T> {

    protected static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    protected final String name;
    protected InventoryType storage = InventoryType.CHEST;
    protected int size = storage.getDefaultSize();
    protected int refresh = 0;
    protected Animation animation = null;
    protected boolean keepOpen = false;
    protected boolean lockBottom = true;
    protected boolean lockEmpty = true;
    protected boolean useBottom = false;
    protected final Map<String, TemplateButton> templateButtons = new HashMap<>();

    public MenuBuilder(String name) {
        Validate.notNull(name, "Name cannot be null");
        this.name = name;
    }

    public MenuBuilder(String name, InventoryType storage) {
        this(name);
        Validate.notNull(storage, "Storage cannot be null");
        this.storage = storage;
        this.size = storage.getDefaultSize();
    }

    public MenuBuilder(@NotNull Config config) {
        name = config.getName();

        storage = config.createNotNull(config::getInventory, "storage");
        size = storage == InventoryType.CHEST ? config.getInt("rows", 3) * 9 : storage.getDefaultSize();
        config.validate(InventoryUtils.isValidInventory(storage, size), "rows", "Invalid number of rows for chest inventory");

        refresh = config.getInt("refresh");
        animation = plugin.getAnimation(config.getString("animation"));
        keepOpen = config.getBoolean("keep-open", false);
        lockBottom = config.getBoolean("lock-bottom", true);
        lockEmpty = config.getBoolean("lock-empty", true);
        useBottom = config.getBoolean("bottom-inventory", false);

        for (String key : config.getKeys("buttons", false)) {
            templateButtons.put(key, config.create(section -> new ButtonBuilder(section).build(), key));
        }

    }

    public String getName() {
        return name;
    }

    public InventoryType getStorage() {
        return storage;
    }

    public MenuBuilder setStorage(InventoryType storage) {
        this.storage = storage;
        this.size = storage.getDefaultSize();
        return this;
    }

    public int getSize() {
        return size;
    }

    public MenuBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public int getRefresh() {
        return refresh;
    }

    public MenuBuilder setRefresh(int refresh) {
        this.refresh = refresh;
        return this;
    }

    public Animation getAnimation() {
        return animation;
    }

    public MenuBuilder setAnimation(Animation animation) {
        this.animation = animation;
        return this;
    }

    public boolean keepOpen() {
        return keepOpen;
    }

    public boolean lockBottom() {
        return lockBottom;
    }

    public boolean lockEmpty() {
        return lockEmpty;
    }

    public boolean useBottom() {
        return useBottom;
    }

    public MenuBuilder keepOpen(boolean keepOpen) {
        this.keepOpen = keepOpen;
        return this;
    }

    public MenuBuilder lockBottom(boolean lockBottom) {
        this.lockBottom = lockBottom;
        return this;
    }

    public MenuBuilder lockEmpty(boolean lockEmpty) {
        this.lockEmpty = lockEmpty;
        return this;
    }

    public MenuBuilder useBottom(boolean useBottom) {
        this.useBottom = useBottom;
        return this;
    }

    public MenuBuilder addCustomButton(String name, Button button) {
        templateButtons.put(name, button);
        return this;
    }

    public MenuBuilder removeCustomButton(String name) {
        templateButtons.remove(name);
        return this;
    }

    public Button getCustomButton(String buttonId) {
        Button button = templateButtons.get(buttonId);
        return button == null ? plugin.getCustomButton(buttonId) : button;
    }

    public MenuSettings getSettings() {
        return new MenuSettings(storage, size, refresh, keepOpen, lockBottom, lockEmpty);
    }

}
