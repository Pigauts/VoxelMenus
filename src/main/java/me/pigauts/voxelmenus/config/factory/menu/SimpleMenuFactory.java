package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.function.ClickFunction;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.util.Path;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class SimpleMenuFactory implements MenuFactory {

    protected String getName(Config config) {
        return config.getName();
    }

    protected MenuSettings getSettings(Config config) {
        InventoryType storage = config.getEnum(InventoryType.class, "storage");
        if (storage == null) {
            storage = InventoryType.CHEST;
        }

        int size = storage.getDefaultSize();
        if (storage == InventoryType.CHEST) {
            size = config.getInt("size", 27);
        }

        return new MenuSettings(storage, size,
                config.getSecondsInTicks("refresh"),
                config.getBoolean("keep-open"),
                config.getBoolean("lock-bottom"),
                config.getBoolean("lock-empty"));
    }


    protected Map<String, ClickFunction> getTemplateFunctions(Config config) {
        Map<String, ClickFunction> functions = new HashMap<>();

        for (String key : config.getKeys("functions", false)) {

            Map<ClickType, Function> functionsByClick = new HashMap<>();

            for (String path : config.getKeysPath("functions." + key, false)) {
                Function function = FactoryUtil.createFunction(config.getSection(path));

                for (ClickType click : config.getEnumSet(ClickType.class, path + ".click")) {
                    functionsByClick.put(click, function);
                }

                functions.put(key, new ClickFunction(functionsByClick));
            }
        }

        return functions;
    }

    protected Map<String, Icon> getTemplateIcons(Config config) {
        Map<String, ClickFunction> functionsByName = getTemplateFunctions(config);
        Map<String, Icon> customButtons = new HashMap<>();

        System.out.println(config.getName());

        for (String key : config.getKeys("icons", false)) {
            ItemStack item = config.getItemStack("icons." + key);
            ClickFunction function = functionsByName.get(config.getString(Path.of("icons", key, "function")));
            boolean locked = config.getBoolean(Path.of("icons", key, "locked"), true);

            customButtons.put(key, new Button(item, function, locked));
        }

        return customButtons;
    }

}
