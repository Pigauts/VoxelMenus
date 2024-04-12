package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.api.core.enums.MenuType;
import me.pigauts.voxelmenus.api.menu.InventoryMeta;
import me.pigauts.voxelmenus.api.menu.view.MenuView;
import me.pigauts.voxelmenus.api.player.MenuPlayer;
import me.pigauts.voxelmenus.core.Conditional;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.view.DynamicMenuView;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DynamicMenu extends SimpleMenu {

    private final Map<String, Conditional<InventoryMeta>> conditionalMetas;

    public DynamicMenu(String name, MenuSettings settings, Map<String, Conditional<InventoryMeta>> conditionalMetas) {
        super(name, settings);
        this.conditionalMetas = conditionalMetas;
    }

    @Override
    public MenuType getType() {
        return MenuType.DYNAMIC;
    }

    @NotNull
    public InventoryMeta getMenuMeta(MenuPlayer player) {
        for (Conditional<InventoryMeta> conditional : conditionalMetas.values()) {
            if (!conditional.isMet(player)) continue;
            return conditional.getResult();
        }
        return conditionalMetas.get("default").getResult();
    }

    @NotNull
    public InventoryMeta getMenuMeta(String name) {
        return conditionalMetas.containsKey(name) ? conditionalMetas.get(name).getResult() : getDefaultMeta();
    }

    @NotNull
    public InventoryMeta getDefaultMeta() {
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
