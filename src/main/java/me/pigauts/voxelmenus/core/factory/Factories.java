package me.pigauts.voxelmenus.core.factory;

import me.pigauts.voxelmenus.API.factory.ActionFactory;
import me.pigauts.voxelmenus.API.factory.ConditionFactory;
import me.pigauts.voxelmenus.API.factory.EntriesFactory;
import me.pigauts.voxelmenus.API.factory.FunctionFactory;
import me.pigauts.voxelmenus.Util;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.VoxelPlugin;
import me.pigauts.voxelmenus.core.config.Config;
import me.pigauts.voxelmenus.core.config.ConfigSection;
import me.pigauts.voxelmenus.API.event.config.ActionLoadEvent;
import me.pigauts.voxelmenus.API.event.config.ConditionLoadEvent;
import me.pigauts.voxelmenus.API.event.config.FunctionLoadEvent;
import me.pigauts.voxelmenus.API.Function;
import me.pigauts.voxelmenus.core.function.action.Action;
import me.pigauts.voxelmenus.core.function.condition.Condition;
import me.pigauts.voxelmenus.API.menu.Menu;
import me.pigauts.voxelmenus.core.config.ConfigKey;
import me.pigauts.voxelmenus.menu.widget.entries.MenuEntries;
import me.pigauts.voxelmenus.message.Message;
import me.pigauts.voxelmenus.util.Pair;
import me.pigauts.voxelmenus.util.SlotItem;
import me.pigauts.voxelmenus.util.Weather;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Factories {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    @Nullable
    public static Menu createMenu(ConfigSection config) {
        if (config == null) return null;
        ConfigFactory<Menu> factory = plugin.getFactories().getMenuFactory(config.getString("type"));
        return factory == null ? null : factory.create(config);
    }

    @Nullable
    public static Message createMessage(ConfigSection config) {
        if (config == null) return null;
        ConfigFactory<Message> factory = plugin.getFactories().getMessageFactory(config.getString("type"));
        return factory == null ? null : factory.create(config);
    }
    
    @Nullable
    public static Function createFunction(Config config) {
        if (config == null) return null;

        FunctionFactory factory = plugin.getFactories().getFunctionFactory(null);

        FunctionLoadEvent event = new FunctionLoadEvent(config, factory);
        VoxelPlugin.callEvent(event);

        return event.getResult();
    }

    @Nullable
    public static Action createAction(Config config) {
        ActionFactory factory = plugin.getActionFactory(config.getKey());

        ActionLoadEvent event = new ActionLoadEvent(config, factory);
        VoxelPlugin.callEvent(event);

        return event.getResult();
    }


    @Nullable
    public static Condition createCondition(Config config) {
        ConditionFactory factory = plugin.getConditionFactory(config.getKey());

        ConditionLoadEvent event = new ConditionLoadEvent(config, factory);
        VoxelPlugin.callEvent(event);

        return event.getResult();
    }

    @Nullable
    public static MenuEntries createEntries(ConfigSection config) {
        if (config == null) return null;
        EntriesFactory factory = plugin.getFactories().getEntriesFactory(config.getString("view"));
        return factory == null ? null : factory.create(config);
    }

    @Nullable
    public static SlotItem createSlotItem(Pair<String, Integer> pair) {
        if (pair == null) return null;
        return new SlotItem(plugin.getItem(pair.key()), pair.value());
    }

    @Nullable
    public static List<SlotItem> createSlotItems(List<Pair<String, Integer>> pairs) {
        List<SlotItem> items = new ArrayList<>();
        for (Pair<String, Integer> pair : pairs) {
            SlotItem item = createSlotItem(pair);

            if (item != null) {
                items.add(item);
            }
        }
        return items;
    }

    @Nullable
    public static Pair<Weather, Integer> createWeatherCondition(Pair<String, Integer> pair) {
        return new Pair<>(Util.getEnum(Weather.class, pair.key()), pair.value());
    }

}
