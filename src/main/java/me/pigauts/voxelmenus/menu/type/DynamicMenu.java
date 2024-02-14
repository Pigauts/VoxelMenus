package me.pigauts.voxelmenus.menu.type;

import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.meta.DynamicMeta;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.view.DynamicMenuView;
import me.pigauts.voxelmenus.menu.view.MenuView;
import me.pigauts.voxelmenus.player.MenuPlayer;

import java.util.Map;

public class DynamicMenu extends SimpleMenu {

    private final Map<String, DynamicMeta> metaByName;

    public DynamicMenu(String name, MenuSettings settings, Map<String, DynamicMeta> metaByName) {
        super(name, settings);
        this.metaByName = metaByName;
    }

    public MenuMeta getMeta(MenuPlayer player) {
        for (DynamicMeta meta : metaByName.values()) {
            if (meta.getCondition().isMet(player))
                return meta;
        }

        return metaByName.get("default");
    }

    public MenuMeta getMetaByName(String name) {
        MenuMeta meta = metaByName.get(name);
        return meta == null ? metaByName.get("default") : meta;
    }

    @Override
    public MenuView createView(MenuPlayer player) {
        return new DynamicMenuView(this, player);
    }

}
