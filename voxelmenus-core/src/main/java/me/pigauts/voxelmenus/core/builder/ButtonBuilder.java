package me.pigauts.voxelmenus.core.builder;

import me.pigauts.voxelmenus.api.config.Config;
import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.button.SimpleTemplateButton;
import me.pigauts.voxelmenus.api.menu.button.TemplateButton;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class ButtonBuilder extends Builder<TemplateButton> {

    private ItemStack buttonItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
    private final Map<ClickType, Function> functions = new HashMap<>();
    private boolean locked = true;
    private int cooldown = 0;

    public ButtonBuilder() {}

    public ButtonBuilder(@NotNull Config config) {
        Validate.notNull(config, "Config cannot be null");
        buttonItem = config.getItemStack("item", plugin.getItem(config.getString("item")));
        functions.put(null, null); //change
        locked = config.getBoolean("locked", true);
        cooldown = config.getInt("cooldown");
    }

    public ButtonBuilder setButtonItem(ItemStack buttonItem) {
        this.buttonItem = buttonItem;
        return this;
    }

    public ButtonBuilder addFunction(ClickType clickType, Function function) {
        functions.put(clickType, function);
        return this;
    }

    public ButtonBuilder setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public ButtonBuilder setCooldown(int cooldown) {
        this.cooldown = cooldown;
        return this;
    }

    public TemplateButton build() {
        return new SimpleTemplateButton(buttonItem, functions, locked, cooldown);
    }

}
