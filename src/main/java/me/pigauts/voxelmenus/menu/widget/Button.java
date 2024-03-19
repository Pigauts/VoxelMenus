package me.pigauts.voxelmenus.menu.widget;

import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.factory.Factories;
import me.pigauts.voxelmenus.item.ItemBuilder;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Button extends ItemStack {

    private Map<ClickType, Function> functions;
    private boolean locked;

    public Button(ItemStack icon, Map<ClickType, Function> functions, boolean locked) {
        super(icon);
        this.functions = functions;
        this.locked = locked;
    }

    @Nullable
    public static Entry fromConfig(Config config) {
        if (config == null) return null;
        ItemStack item = new ItemBuilder(config).build();
        boolean locked = config.getBoolean("locked", true);
        Map<ClickType, Function> functions = new HashMap<>();
        for (String key : config.getKeys("functions", false)) {
            Function function = config.getAtSection(Factories::createFunction, key);
            for (ClickType click : config.get(config::getClickList, "functions", key, "clicks")) {
                functions.put(click, function);
            }
        }
        return null; // new Entry(item, functions, locked);
    }

    public Function getFunction(ClickType click) {
        return functions.get(click);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void click(MenuPlayer player, InventoryClickEvent event) {
        if (locked) {
            event.setCancelled(true);
        } else if (event.getCurrentItem() == null) {
            return;
        }

        player.executeFunction(functions.get(event.getClick()));
    }

    @Override
    public Button clone() {
        return new Button(super.clone(), functions, locked);
    }

}
