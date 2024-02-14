package me.pigauts.voxelmenus.menu.meta;

import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.menu.widget.Icon;

public class DynamicMeta extends SimpleMeta {

    public final static DynamicMeta DEFAULT = new DynamicMeta("default", new Icon[54], MenuFunctions.DEFAULT, Condition.DEFAULT);

    private final Condition condition;

    public DynamicMeta(String title, Icon[] icons, MenuFunctions functions, Condition condition) {
        super(title, icons, functions);
        this.condition = condition;
    }


    public Condition getCondition() {
        return condition;
    }

}
