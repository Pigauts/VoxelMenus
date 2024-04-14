package me.pigauts.voxelmenus.api.core.enums;

public class ActionType {
    private ActionType() {}

    // Cache actions
    public static final String CACHE_INVENTORY = "CACHE_INVENTORY";
    public static final String FLUSH_INVENTORY = "FLUSH_INVENTORY";
    public static final String LOAD_INVENTORY = "LOAD_INVENTORY";
    public static final String CACHE_PLAYER_INVENTORY = "CACHE_PLAYER_INVENTORY";
    public static final String FLUSH_PLAYER_INVENTORY = "FLUSH_PLAYER_INVENTORY";
    public static final String LOAD_PLAYER_INVENTORY = "LOAD_PLAYER_INVENTORY";
    public static final String CACHE_PLACEHOLDER = "CACHE_PLACEHOLDER";
    public static final String CACHE_PLACEHOLDERS = "CACHE_PLACEHOLDERS";
    public static final String FLUSH_PLACEHOLDER = "FLUSH_PLACEHOLDER";
    public static final String FLUSH_PLACEHOLDERS = "FLUSH_PLACEHOLDERS";
    // Cache items
    public static final String CACHE_CURSOR_ITEM = "CACHE_CURSOR_ITEM";
    public static final String CACHE_INVENTORY_ITEM = "CACHE_INVENTORY_ITEM";
    public static final String CACHE_PLAYER_ITEM = "CACHE_PLAYER_ITEM";
    public static final String FLUSH_ITEM = "FLUSH_ITEM";
    // Clear actions
    public static final String CLEAR_INVENTORY = "CLEAR_INVENTORY";
    public static final String CLEAR_PLAYER_INVENTORY = "CLEAR_PLAYER_INVENTORY";
    // Set actions
    public static final String SET_BUTTON = "SET_BUTTON";
    public static final String SET_BUTTONS = "SET_BUTTONS";
    public static final String SET_FUNCTION = "SET_FUNCTION";
    public static final String SET_FUNCTIONS = "SET_FUNCTIONS";
    public static final String SET_ITEM = "SET_ITEM";
    public static final String SET_ITEMS = "SET_ITEMS";
    public static final String CLEAR_SLOT = "CLEAR_SLOT";
    // Menu actions
    public static final String OPEN_MENU = "OPEN_MENU";
    public static final String CLOSE_MENU = "CLOSE_MENU";
    public static final String CLEAR_MENU = "CLEAR_MENU";
    public static final String REFRESH_MENU = "REFRESH_MENU";
    public static final String NEXT_PAGE = "NEXT_PAGE";
    public static final String PREVIOUS_PAGE = "PREVIOUS_PAGE";
    // Scroll actions
    public static final String SCROLL_UP = "SCROLL_UP";
    public static final String SCROLL_DOWN = "SCROLL_DOWN";
    public static final String SCROLL_LEFT = "SCROLL_LEFT";
    public static final String SCROLL_RIGHT = "SCROLL_RIGHT";
    public static final String SCROLL_UP_LEFT = "SCROLL_UP_LEFT";
    public static final String SCROLL_DOWN_LEFT = "SCROLL_DOWN_LEFT";
    public static final String SCROLL_UP_RIGHT = "SCROLL_UP_RIGHT";
    public static final String SCROLL_DOWN_RIGHT = "SCROLL_DOWN_RIGHT";
    // Other actions
    public static final String OPEN_ENDERCHEST = "OPEN_ENDERCHEST";
    public static final String HEAL = "HEAL";
    public static final String DAMAGE = "DAMAGE";
    public static final String FEED = "FEED";
    public static final String ENCHANT_ITEM = "ENCHANT_ITEM";
    public static final String POTION_EFFECT = "POTION_EFFECT";
    public static final String MESSAGE = "MESSAGE";
    public static final String CUSTOM_MESSAGE = "CUSTOM_MESSAGE";
    public static final String SET_EXP = "SET_EXP";
    public static final String ADD_EXP = "ADD_EXP";
    public static final String REMOVE_EXP = "REMOVE_EXP";
    public static final String ADD_FLAG = "GIVE_FLAG";
    public static final String TAKE_FLAG = "TAKE_FLAG";
    public static final String SET_FLIGHT = "SET_FLIGHT";
    public static final String GIVE_ITEM = "GIVE_ITEM";
    public static final String TAKE_ITEM = "TAKE_ITEM";
    public static final String DROP_ITEM = "DROP_ITEM";
    public static final String SET_CURSOR_ITEM = "SET_CURSOR_ITEM";
    public static final String REMOVE_CURSOR_ITEM = "REMOVE_CURSOR_ITEM";
    public static final String SOUND = "SOUND";
    public static final String PARTICLE = "PARTICLE";
    public static final String WORLD = "WORLD";
    public static final String TELEPORT = "TELEPORT";
    public static final String CHAT = "CHAT";
    public static final String COMMAND = "COMMAND";
    public static final String OP_COMMAND = "OP_COMMAND";
    public static final String CONSOLE_COMMAND = "CONSOLE_COMMAND";
    public static final String WEATHER = "WEATHER";
    public static final String GIVE_VAULT = "GIVE_VAULT";
    public static final String DROP_ITEMS = "DROP_ITEMS";
    public static final String GIVE_ITEMS = "GIVE_ITEMS";

}
