package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.config.IconLayoutBuilder;
import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import me.pigauts.voxelmenus.menu.meta.DynamicMeta;
import me.pigauts.voxelmenus.util.Path;

import java.util.HashMap;
import java.util.Map;

public class DynamicMenuFactory extends SimpleMenuFactory {

    @Override
    public Menu createMenu(Config config) {
        Map<String, DynamicMeta> metaByName = getMenuMetas(config);

        if (!metaByName.containsKey("default")) {
            metaByName.put("default", DynamicMeta.DEFAULT);
        }

        return new DynamicMenu(getName(config), getSettings(config), metaByName);
    }

    protected Map<String, DynamicMeta> getMenuMetas(Config config) {

        IconLayoutBuilder layoutBuilder = new IconLayoutBuilder(getTemplateIcons(config));

        Map<String, DynamicMeta> metaByName = new HashMap<>();

        for (String key : config.getKeys("layouts", false)) {

            String title = config.getColorString(Path.of("layouts", key, "title"));

            if (title.isEmpty()) {
                title = config.getString("title");
            }

            Icon[] buttons = layoutBuilder.build(config.getLayout(Path.of("layouts", key, "layout")));

            MenuMeta.MenuFunctions functions = new MenuMeta.MenuFunctions(
                    FactoryUtil.createFunction(config.getSection(Path.of("layouts", key, "on-open"))),
                    FactoryUtil.createFunction(config.getSection(Path.of("layouts", key, "on-close"))),
                    FactoryUtil.createFunction(config.getSection(Path.of("layouts", key, "on-update"))));

            if (key.equalsIgnoreCase("default")) {
                metaByName.put("default", new DynamicMeta(title, buttons, functions, Condition.DEFAULT));
                continue;
            }

            Condition condition = FactoryUtil.createConditionSet(config.getSection(Path.of("layouts", key, "conditions")));

            metaByName.put(key, new DynamicMeta(title, buttons, functions, condition));
        }

        return metaByName;
    }

}
