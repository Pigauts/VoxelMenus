package me.pigauts.voxelmenus.menu.meta;

import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.menu.widget.Icon;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public interface MenuMeta {

    record MenuFunctions(Function openFunction, Function closeFunction, Function updateFunction) {
        public static final MenuFunctions DEFAULT = new MenuFunctions(null, null, null);
    }

    @NotNull
    String getTitle();

    @NotNull
    Icon[] getIcons();

    @Nullable
    default Icon getIcon(int index) {
        Icon[] icons = getIcons();
        return icons.length > index ? icons[index] : null;
    }

    @Nullable
    Function getOpenFunction();

    @Nullable
    Function getCloseFunction();

    @Nullable
    Function getUpdateFunction();

}
