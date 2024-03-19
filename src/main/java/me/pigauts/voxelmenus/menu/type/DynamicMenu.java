package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.API.MenuType;
import me.pigauts.voxelmenus.menu.MenuMeta;
import me.pigauts.voxelmenus.core.builder.DynamicMenuBuilder;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.view.DynamicMenuView;
import me.pigauts.voxelmenus.API.menu.MenuView;
import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.util.Conditional;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DynamicMenu extends SimpleMenu {

    private final Map<String, Conditional<MenuMeta>> conditionalMetas;

    public DynamicMenu(String name, MenuSettings settings, Map<String, Conditional<MenuMeta>> conditionalMetas) {
        super(name, settings);
        this.conditionalMetas = conditionalMetas;
    }

    @Override
    public MenuType getType() {
        return MenuType.DYNAMIC;
    }

    public static DynamicMenu fromConfig(ConfigSection config) {
        if (config == null) return null;
        return new DynamicMenuBuilder(config).build();
    }

    @NotNull
    public MenuMeta getMenuMeta(MenuPlayer player) {
        for (Conditional<MenuMeta> conditional : conditionalMetas.values()) {
            if (!conditional.isMet(player)) continue;
            return conditional.getResult();
        }
        return conditionalMetas.get("default").getResult();
    }

    @NotNull
    public MenuMeta getMenuMeta(String name) {
        return conditionalMetas.containsKey(name) ? conditionalMetas.get(name).getResult() : getDefaultMeta();
    }

    @NotNull
    public MenuMeta getDefaultMeta() {
        return conditionalMetas.get("default").getResult();
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new DynamicMenuView(this, player);
    }

    public MenuView createView(MenuPlayer player, String name) {
        return new DynamicMenuView(this, player, getMenuMeta(name));
    }

}
