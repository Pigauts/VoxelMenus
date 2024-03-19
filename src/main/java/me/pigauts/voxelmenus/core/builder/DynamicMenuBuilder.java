package me.pigauts.voxelmenus.core.builder;

import me.pigauts.voxelmenus.API.MenuAction;
import me.pigauts.voxelmenus.core.factory.Factories;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import me.pigauts.voxelmenus.core.function.condition.ConditionSet;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import me.pigauts.voxelmenus.menu.widget.Button;
import me.pigauts.voxelmenus.util.Conditional;
import me.pigauts.voxelmenus.util.MenuLayout;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class DynamicMenuBuilder extends MenuBuilder<DynamicMenu> {

    private final Map<String, Conditional<MenuMeta>> conditionalMetas = new HashMap<>();

    public DynamicMenuBuilder(String name) {
        super(name);
    }

    public DynamicMenuBuilder(@NotNull ConfigSection config) {
        super(config);

        for (String key : config.getKeys("instances", false)) {
            String title = config.getNotNull(config::getString, "instances", key, "title");
            Button[] buttons = config.getAtKey(MenuLayout::fromConfig, "instances", key, "layout").apply(this);
            MenuMeta meta = new MenuMeta(title, buttons);

            meta.addFunction(MenuAction.OPEN, config.getAtSection(Factories::createFunction, "instances", key, "on-open"));
            meta.addFunction(MenuAction.CLOSE, config.getAtSection(Factories::createFunction, "instances", key, "on-close"));
            meta.addFunction(MenuAction.UPDATE, config.getAtSection(Factories::createFunction, "instances", key, "on-update"));
            meta.addFunction(MenuAction.BACKTRACK, config.getAtSection(Factories::createFunction, "instances", key, "on-backtrack"));

            if (key.equalsIgnoreCase("default")) {
                conditionalMetas.put("default", new Conditional<>(Condition.DEFAULT, meta));
                continue;
            }

            Condition condition = config.getAtSection(ConditionSet::fromConfig, "instances", key, "conditions");

            conditionalMetas.put(key, new Conditional<>(condition, meta));
        }

    }

    @Override
    public DynamicMenu build() {
        return new DynamicMenu(name, getSettings(), conditionalMetas);
    }

    public Map<String, Conditional<MenuMeta>> getConditionalMetas() {
        return conditionalMetas;
    }

    public DynamicMenuBuilder add(String name, Conditional<MenuMeta> conditionalMeta) {
        conditionalMetas.put(name, conditionalMeta);
        return this;
    }

    public DynamicMenuBuilder remove(String name) {
        conditionalMetas.remove(name);
        return this;
    }

}
