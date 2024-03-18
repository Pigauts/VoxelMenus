package me.pigauts.voxelmenus.core.factory;

import me.pigauts.voxelmenus.API.MenusPlugin;
import me.pigauts.voxelmenus.API.factory.*;
import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.core.builder.DynamicMenuBuilder;
import me.pigauts.voxelmenus.core.builder.StaticMenuBuilder;
import me.pigauts.voxelmenus.core.function.ConditionalFunction;
import me.pigauts.voxelmenus.core.function.LoopedFunction;
import me.pigauts.voxelmenus.core.function.SimpleFunction;
import me.pigauts.voxelmenus.core.function.action.menu.*;
import me.pigauts.voxelmenus.core.function.action.player.*;
import me.pigauts.voxelmenus.core.function.action.world.DropItem;
import me.pigauts.voxelmenus.core.function.action.world.DropItems;
import me.pigauts.voxelmenus.core.function.action.world.SetWeather;
import me.pigauts.voxelmenus.core.function.condition.FlagCondition;
import me.pigauts.voxelmenus.core.function.condition.PermCondition;
import me.pigauts.voxelmenus.menu.widget.entries.CustomEntries;
import me.pigauts.voxelmenus.menu.widget.entries.MaterialEntries;
import me.pigauts.voxelmenus.menu.widget.entries.PlayerEntries;
import me.pigauts.voxelmenus.message.type.BossBarMessage;
import me.pigauts.voxelmenus.message.type.ChatMessage;
import me.pigauts.voxelmenus.message.type.TitleMessage;
import me.pigauts.voxelmenus.player.VoxelMenuPlayer;
import me.pigauts.voxelmenus.util.Deserialize;
import me.pigauts.voxelmenus.util.SlotItem;
import me.pigauts.voxelmenus.util.WeatherCondition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultFactories {

    private static final MenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    public static Map<String, MenuFactory> getMenuFactories() {
        Map<String, MenuFactory> menuFactories = new HashMap<>();

        menuFactories.put("static", config -> new StaticMenuBuilder(config).build());
        menuFactories.put("dynamic", config -> new DynamicMenuBuilder(config).build());

        return menuFactories;
    }

    public static Map<String, MessageFactory> getMessageFactories() {
        Map<String, MessageFactory> messsageFactories = new HashMap<>();

        messsageFactories.put("chat", ChatMessage::fromConfig);
        messsageFactories.put("title", TitleMessage::fromConfig);
        messsageFactories.put("bossbar", BossBarMessage::fromConfig);

        return messsageFactories;
    }

    public static Map<String, ConditionFactory> getConditionFactories() {
        Map<String, ConditionFactory> factories = new HashMap<>();

        factories.put("PERMISSION", value -> new PermCondition(value.getString()));
        factories.put("FLAG", value -> new FlagCondition(value.getString()));


        return factories;
    }

    public static Map<String, ActionFactory> getActionFactories() {
        Map<String, ActionFactory> factories = new HashMap<>();

        factories.put("ADD_EXP", value -> new AddExp(value.getInt()));
        factories.put("REMOVE_EXP", value -> new RemoveExp(value.getInt()));
        factories.put("SET_EXP", value -> new SetExp(value.getInt()));
        factories.put("CLEAR_MENU", value -> new ClearMenu());
        factories.put("CLEAR_INVENTORY", value -> new ClearInventory());
        factories.put("CLOSE_MENU", value -> new CloseMenu());
        factories.put("COMMAND", value -> new ExecuteCommand(value.getString()));
        factories.put("HEAL", value -> new Heal(value.getInt()));
        factories.put("DAMAGE", value -> new DamageAction(value.getInt()));
        factories.put("DROP_ITEM", value -> new DropItem(plugin.getItem(value.getString())));
        factories.put("DROP_ITEMS", value -> new DropItems(plugin.getItems(value.getStringList())));
        factories.put("GIVE_ITEM", value -> new GiveItem(plugin.getItem(value.getString())));
        factories.put("GIVE_ITEMS", value -> new GiveItems(plugin.getItems(value.getStringList())));
        factories.put("MESSAGE", value -> new SendMessage(plugin.getMessage(value.getString())));
        factories.put("CHAT_MSG", value -> new SendChatMessage(value.getString()));
        factories.put("NEXT_PAGE", value -> new NextPage());
        factories.put("OP_COMMAND", value -> new ExecuteOpCommand(value.getString()));
        factories.put("OPEN_MENU", value -> new OpenMenu(value.getString()));
        factories.put("PREVIOUS_PAGE", value -> new PreviousPage());
        factories.put("ADD_FLAG", value -> new AddFlag(value.getString()));
        factories.put("SET_FLIGHT", value -> new SetFlight(value.getBoolean()));

        factories.put("SET_ITEM", value -> new SetItem(SlotItem.deserialize(value.getString())));
        factories.put("SET_ITEMS", value -> {
            List<SlotItem> items = new ArrayList<>();
            for (String raw : value.getStringList()) {
                items.add(SlotItem.deserialize(raw));
            }
            return new SetItems(items);
        });

        factories.put("SET_WEATHER", value -> new SetWeather(WeatherCondition.deserialize(value.getString())));
        factories.put("TELEPORT", value -> new Teleport(Deserialize.location(value.getString())));
        factories.put("REFRESH_MENU", value -> new RefreshMenu());

        factories.put("CACHE_PLACEHOLDER", value -> null);
        factories.put("FLUSH_PLACEHOLDER", value -> null);


        return factories;
    }

    public static Map<String, EntriesFactory> getMenuEntriesFactory() {
        Map<String, EntriesFactory> factories = new HashMap<>();

        factories.put("PLAYERS", config -> PlayerEntries.DEFAULT_ENTRIES);
        factories.put("MATERIALS", config -> MaterialEntries.DEFAULT_ENTRIES);
        factories.put("CUSTOM", config -> CustomEntries.fromConfig(config));

        return factories;
    }

    public static Map<String, FunctionFactory> getFunctionFactories() {
        Map<String, FunctionFactory> factories = new HashMap<>();

        factories.put("SIMPLE", SimpleFunction::fromConfig);
        factories.put("CONDITION", ConditionalFunction::fromConfig);
        factories.put("LOOPED", LoopedFunction::fromConfig);

        return factories;
    }

    public static PlayerFactory getPlayerFactory() {
        return player -> new VoxelMenuPlayer(player.getUniqueId());
    }

}
