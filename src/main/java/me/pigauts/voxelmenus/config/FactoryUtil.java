package me.pigauts.voxelmenus.config;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.event.config.ActionLoadEvent;
import me.pigauts.voxelmenus.event.config.ConditionLoadEvent;
import me.pigauts.voxelmenus.event.config.StatementLoadEvent;
import me.pigauts.voxelmenus.function.Function;
import me.pigauts.voxelmenus.function.statement.Statement;
import me.pigauts.voxelmenus.function.statement.action.Action;
import me.pigauts.voxelmenus.function.statement.condition.Condition;
import me.pigauts.voxelmenus.function.statement.condition.ConditionSet;
import me.pigauts.voxelmenus.menu.Menu;
import org.apache.commons.lang.Validate;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class FactoryUtil {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    @Nullable
    public static Statement createStatement(Config section) {
        if (section == null) return null;

        StatementLoadEvent event = new StatementLoadEvent(section, plugin.getFactory().createStatement(section));
        VoxelPlugin.callEvent(event);

        return event.getResult();
    }

    @Nullable
    public static Action createAction(String key, Object value) {
        ActionLoadEvent event = new ActionLoadEvent(key, value, plugin.getFactory().createAction(key, value));
        VoxelPlugin.callEvent(event);

        return event.getResult();
    }

    @Nullable
    public static Condition createCondition(String key, Object value) {
        ConditionLoadEvent event = new ConditionLoadEvent(key, value, plugin.getFactory().createCondition(key, value));
        VoxelPlugin.callEvent(event);

        return event.getResult();
    }

    @Nullable
    public static ConditionSet createConditionSet(Config section) {
        if (section == null) return null;

        List<Condition> conditions = new ArrayList<>();

        for (String key : section.getKeys(false)) {
            conditions.add(createCondition(key, section.get(key)));
        }

        return new ConditionSet(conditions);
    }

    @Nullable
    public static Function createFunction(Config section) {
        if (section == null) return null;

        List<Statement> statements = new ArrayList<>();

        for (Config subSection : section.getSections()) {
            statements.add(createStatement(subSection));
        }

        return new Function(statements);
    }

    @Nullable
    public static Menu createMenu(Config config) {
        return plugin.getFactory().createMenu(config);
    }

}
