package me.pigauts.voxelmenus.API;

import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.menu.Menu;
import me.pigauts.voxelmenus.menu.type.DynamicMenu;
import me.pigauts.voxelmenus.menu.type.StaticMenu;

public class MenuBuilder {

    private final String name;
    private MenuType type = MenuType.STATIC;
    private String title = "No title set";
    private int size = 9;
    private int refresh = 0;
    private Function openFunction = null;
    private Function closeFunction = null;
//    private Contents contents = Contents.EMPTY_INVENTORY;
//    private ConditionalMap<Contents> contentsByCondition = new ConditionalMap<>();

    public MenuBuilder(String name) {
        this.name = name;
    }

//    public Menu build() {
//
//        if (type == MenuType.DYNAMIC) {
//            return new DynamicMenu(name, title, size, refresh, openFunction, closeFunction, contentsByCondition);
//        }
//
//        return new StaticMenu(name, title, size, refresh, openFunction, closeFunction, contents);
//    }

    public MenuBuilder setType(MenuType type) {
        this.type = type;
        return this;
    }

    public MenuBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MenuBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public MenuBuilder setRefresh(int refresh) {
        this.refresh = refresh;
        return this;
    }

    public MenuBuilder setOpenFunction(Function openFunction) {
        this.openFunction = openFunction;
        return this;
    }

    public MenuBuilder setCloseFunction(Function closeFunction) {
        this.closeFunction = closeFunction;
        return this;
    }

//    public MenuBuilder setContents(Contents contents) {
//        this.contents = contents;
//        return this;
//    }
//
//    public MenuBuilder addContents(Condition condition, Contents contents) {
//        if (condition != null && contents != null) {
//            contentsByCondition.put(condition, contents);
//        }
//        return this;
//    }

}
