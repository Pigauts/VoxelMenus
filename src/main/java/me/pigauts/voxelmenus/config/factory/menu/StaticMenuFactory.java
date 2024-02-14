package me.pigauts.voxelmenus.config.factory.menu;

import me.pigauts.voxelmenus.config.IconLayoutBuilder;
import me.pigauts.voxelmenus.config.Config;
import me.pigauts.voxelmenus.config.FactoryUtil;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.type.StaticMenu;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.meta.SimpleMeta;

public class StaticMenuFactory extends SimpleMenuFactory {

    @Override
    public Menu createMenu(Config config) {
        return new StaticMenu(getName(config), getSettings(config), getMeta(config));
    }

    protected String getTitle(Config config) {
        return config.getColorString("title");
    }

    protected Icon[] getIcons(Config config) {
        return new IconLayoutBuilder(getTemplateIcons(config)).build(config.getLayout("layout"));
    }

    protected MenuMeta.MenuFunctions getFunctions(Config config) {
        return new MenuMeta.MenuFunctions(
                FactoryUtil.createFunction(config.getSection("on-open")),
                FactoryUtil.createFunction(config.getSection("on-close")),
                FactoryUtil.createFunction(config.getSection("on-update")));
    }

    protected MenuMeta getMeta(Config config) {
        return new SimpleMeta(
                getTitle(config),
                getIcons(config),
                getFunctions(config));
    }

}
