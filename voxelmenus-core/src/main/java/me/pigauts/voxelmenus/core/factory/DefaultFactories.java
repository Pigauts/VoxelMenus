package me.pigauts.voxelmenus.core.factory;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.api.core.enums.FunctionType;
import me.pigauts.voxelmenus.api.factory.*;
import me.pigauts.voxelmenus.core.builder.function.ConditionalFunctionBuilder;
import me.pigauts.voxelmenus.core.builder.function.SimpleFunctionBuilder;
import me.pigauts.voxelmenus.core.builder.function.SwitchFunctionBuilder;
import me.pigauts.voxelmenus.core.builder.menu.DynamicMenuBuilder;
import me.pigauts.voxelmenus.core.builder.menu.StaticMenuBuilder;
import me.pigauts.voxelmenus.core.builder.message.BossBarMsgBuilder;
import me.pigauts.voxelmenus.core.builder.message.TitleMsgBuilder;
import me.pigauts.voxelmenus.api.core.enums.ActionType;
import me.pigauts.voxelmenus.function.action.menu.*;
import me.pigauts.voxelmenus.function.action.player.*;
import me.pigauts.voxelmenus.function.action.world.DropItem;
import me.pigauts.voxelmenus.function.action.world.DropItems;
import me.pigauts.voxelmenus.function.condition.FlagCondition;
import me.pigauts.voxelmenus.function.condition.PermCondition;
import me.pigauts.voxelmenus.message.type.ActionBarMessage;
import me.pigauts.voxelmenus.message.type.ChatMessage;
import me.pigauts.voxelmenus.player.VoxelMenuPlayer;

import java.util.HashMap;
import java.util.Map;

public class DefaultFactories {

    private static final VoxelMenusPlugin plugin = VoxelMenusPlugin.getPlugin();

    public static Map<String, MenuFactory> getMenuFactories() {
        Map<String, MenuFactory> menuFactories = new HashMap<>();

        menuFactories.put("static", config -> new StaticMenuBuilder(config).build());
        menuFactories.put("dynamic", config -> new DynamicMenuBuilder(config).build());

        return menuFactories;
    }

    public static Map<String, MessageFactory> getMessageFactories() {
        Map<String, MessageFactory> messsageFactories = new HashMap<>();

        messsageFactories.put("chat", config -> new ChatMessage(config.getString()));
        messsageFactories.put("title", config -> new TitleMsgBuilder().build());
        messsageFactories.put("boss-bar", config -> new BossBarMsgBuilder().build());
        messsageFactories.put("action-bar", config -> new ActionBarMessage(config.getString("message")));

        return messsageFactories;
    }

    public static Map<String, ConditionFactory> getConditionFactories() {
        Map<String, ConditionFactory> factories = new HashMap<>();

        factories.put("PERMISSION", (ConditionFactory.Str) PermCondition::new);
        factories.put("FLAG", (ConditionFactory.Str) FlagCondition::new);

        return factories;
    }

    public static Map<String, ActionFactory> getActionFactories() {
        Map<String, ActionFactory> factories = new HashMap<>();

        factories.put(ActionType.ADD_EXP, (ActionFactory.Int) AddExp::new);
        factories.put(ActionType.REMOVE_EXP, (ActionFactory.Int) RemoveExp::new);
        factories.put(ActionType.SET_EXP, (ActionFactory.Int) SetExp::new);
        factories.put(ActionType.HEAL, (ActionFactory.Int) Heal::new);
        factories.put(ActionType.DAMAGE, (ActionFactory.Int) Damage::new);

        factories.put(ActionType.COMMAND, (ActionFactory.Str) ExecuteCommand::new);
        factories.put(ActionType.OP_COMMAND, (ActionFactory.Str) ExecuteOpCommand::new);
        factories.put(ActionType.ADD_FLAG, (ActionFactory.Str) flagId -> new AddFlag(plugin.getFlag(flagId)));
        factories.put(ActionType.CUSTOM_MESSAGE, (ActionFactory.Str) messageId -> new SendMessage(plugin.getMessage(messageId)));
        factories.put(ActionType.MESSAGE, (ActionFactory.Str) SendChatMessage::new);
        factories.put(ActionType.OPEN_MENU, (ActionFactory.Str) OpenMenu::new);
        factories.put(ActionType.DROP_ITEM, (ActionFactory.Str) itemId -> new DropItem(plugin.getItem(itemId)));
        factories.put(ActionType.GIVE_ITEM, (ActionFactory.Str) itemId -> new GiveItem(plugin.getItem(itemId)));

        factories.put(ActionType.CLEAR_MENU, (ActionFactory.Def) ClearMenu::new);
        factories.put(ActionType.CLEAR_INVENTORY, (ActionFactory.Def) ClearInventory::new);
        factories.put(ActionType.CLOSE_MENU, (ActionFactory.Def) CloseMenu::new);
        factories.put(ActionType.NEXT_PAGE, (ActionFactory.Def) NextPage::new);
        factories.put(ActionType.PREVIOUS_PAGE, (ActionFactory.Def) PreviousPage::new);
        factories.put(ActionType.REFRESH_MENU, (ActionFactory.Def) RefreshMenu::new);

        factories.put(ActionType.SET_FLIGHT, (ActionFactory.Bol) SetFlight::new);

        factories.put(ActionType.DROP_ITEMS, (ActionFactory.StrList) itemIds -> new DropItems(plugin.getItems(itemIds)));
        factories.put(ActionType.GIVE_ITEMS, (ActionFactory.StrList) itemIds -> new GiveItems(plugin.getItems(itemIds)));

//
//        factories.put("SET_ITEM", config -> new SetItem(SlotItem.deserialize(config.getString())));
//        factories.put("SET_ITEMS", config -> {
//            List<SlotItem> items = new ArrayList<>();
//            for (String raw : config.getStringList()) {
//                items.add(SlotItem.deserialize(raw));
//            }
//            return new SetItems(items);
//        });
//
//        factories.put("SET_WEATHER", config -> new SetWeather(WeatherCondition.deserialize(config.getString())));
//        factories.put("TELEPORT", config -> new Teleport(Deserialize.location(config.getString())));

//
//        factories.put("CACHE_PLACEHOLDER", config -> null);
//        factories.put("FLUSH_PLACEHOLDER", config -> null);

        return factories;
    }

    public static Map<String, EntriesFactory> getMenuEntriesFactory() {
        Map<String, EntriesFactory> factories = new HashMap<>();

//        factories.put("PLAYERS", config -> PlayerEntries.DEFAULT_ENTRIES);
//        factories.put("MATERIALS", config -> MaterialEntries.DEFAULT_ENTRIES);
//        factories.put("CUSTOM", config -> CustomEntries.fromConfig(config));

        return factories;
    }

    public static Map<String, FunctionFactory> getFunctionFactories() {
        Map<String, FunctionFactory> factories = new HashMap<>();

        factories.put(FunctionType.SIMPLE, config -> new SimpleFunctionBuilder(config).build());
        factories.put(FunctionType.CONDITIONAL, config -> new ConditionalFunctionBuilder(config).build());
        factories.put(FunctionType.SWITCH, config -> new SwitchFunctionBuilder(config).build());

        return factories;
    }

    public static PlayerFactory getPlayerFactory() {
        return player -> new VoxelMenuPlayer(player.getUniqueId());
    }

}
