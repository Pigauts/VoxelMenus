package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.function.ClickFunction;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.button.Button;
import me.pigauts.voxelmenus.menu.button.SimpleButton;
import me.pigauts.voxelmenus.util.Path;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class SimpleMenuFactory implements MenuFactory {

    protected String createName(Config config) {
        return config.getName();
    }

    protected String createTitle(Config config) {
        return config.getColorString("title");
    }

    protected int createSize(Config config) {
        return config.getInt("rows") * 9;
    }

    protected int createRefresh(Config config) {
        return config.getInt("refresh");
    }

    protected Function createOpenFunction(Config config) {
        return FactoryUtil.createFunction(config.getSection("on-open"));
    }

    protected Function createCloseFunction(Config config) {
        return FactoryUtil.createFunction(config.getSection("on-close"));
    }

    protected Map<String, ClickFunction> createCustomFunctions(Config config) {
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

    protected Map<String, Button> createCustomButtons(Config config) {
        Map<String, ClickFunction> functionsByName = createCustomFunctions(config);
        Map<String, Button> customButtons = new HashMap<>();

        for (String key : config.getKeys("items", false)) {
            ItemStack item = config.getItemStack("items." + key);
            ClickFunction function = functionsByName.get(config.getString(Path.of("items", key, "function")));

            customButtons.put(key, new SimpleButton(item, function));
        }

        return customButtons;
    }

}
