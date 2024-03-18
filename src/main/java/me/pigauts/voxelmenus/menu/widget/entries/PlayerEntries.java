package me.pigauts.voxelmenus.menu.widget.entries;

import me.pigauts.voxelmenus.menu.widget.Entry;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class PlayerEntries implements MenuEntries {

    public static final PlayerEntries DEFAULT_ENTRIES = new PlayerEntries();

//    public int getTotalPages() {
//        int[] slots = getEntrySlots();
//        int slotsPerPage = slots.length;
//        var players = Menus.getMenuPlayersList();
//        int totalPlayers = players.size();
//        int totalPages = (int) Math.ceil((double) totalPlayers / slotsPerPage);
//
//        return totalPages;
//    }
//
//    public MenuMeta getMeta(int page) {
//        int[] slots = getEntrySlots();
//        int slotsPerPage = slots.length;
//        var players = Menus.getMenuPlayersList();
//        int totalPlayers = players.size();
//        int totalPages = (int) Math.ceil((double) totalPlayers / slotsPerPage);
//
//        if (page < 1 || page > totalPages) {
//            return null;
//        }
//
//        int startIndex = (page - 1) * slotsPerPage;
//        int endIndex = Math.min(page * slotsPerPage, totalPlayers);
//
//          Icon[] buttons = meta.getIcons();
//
//        for (int i = startIndex, j = 0; i < endIndex; i++, j++) {
//            Button button = new Button(players.get(i).getPlayerHead());
//
//              button.setItemMeta(getTemplate().getItemMeta());
//
//              buttons[slots[j]] = button;
//        }
//
//        return null;
//    }


    @Override
    public Entry get(int index) {
        return null;
    }

    @Override
    public void set(int index, Entry entry) {

    }

    @Override
    public void add(Entry entry) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void sort(String type) {

    }

    @NotNull
    @Override
    public Iterator<Entry> iterator() {
        return null;
    }

}
