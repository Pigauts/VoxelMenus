package me.pigauts.voxelmenus.api.menu.button;

import me.pigauts.voxelmenus.api.function.Function;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.Map;

public class SimpleTemplateButton implements TemplateButton {

    private final ItemStack buttonItem;
    private Map<ClickType, Function> functions;
    private boolean locked;
    private int cooldown;

    public SimpleTemplateButton(ItemStack buttonItem, Map<ClickType, Function> functions, boolean locked) {
        this(buttonItem, functions, locked, 0);
    }

    public SimpleTemplateButton(ItemStack buttonItem, Map<ClickType, Function> functions, boolean locked, int cooldown) {
        this.buttonItem = buttonItem;
        this.functions = functions;
        this.locked = locked;
        this.cooldown = cooldown;
    }

//    @Nullable
//    public static MenuEntry fromConfig(Config config) {
//        if (config == null) return null;
//        ItemStack item = new ItemBuilder(config).build();
//        boolean locked = config.getBoolean("locked", true);
//        Map<ClickType, Function> functions = new HashMap<>();
//        for (String key : config.getKeys("functions", false)) {
//            Function function = config.getAt(Factories::createFunction, key);
//            for (ClickType click : config.get(config::getClickList, "functions", key, "clicks")) {
//                functions.put(click, function);
//            }
//        }
//        return null; // new Entry(item, functions, locked);
//    }

    @Override
    public ViewButton createViewButton(MenuView view) {
        return new SimpleViewButton(view, this);
    }

    public ItemStack getButtonItem() {
        return buttonItem.clone();
    }

    public Function getFunction(ClickType click) {
        return functions.get(click);
    }

    public TemplateButton addFunction(ClickType click, Function function) {
        functions.put(click, function);
        return this;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Map<ClickType, Function> getFunctions() {
        return Collections.unmodifiableMap(functions);
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public void removeFunction(ClickType click) {
        functions.remove(click);
    }

    @Override
    public void clearFunctions() {
        functions.clear();
    }

    @Override
    public boolean hasFunction(ClickType click) {
        return functions.containsKey(click);
    }

}
