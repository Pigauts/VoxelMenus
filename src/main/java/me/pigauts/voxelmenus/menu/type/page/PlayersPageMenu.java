package me.pigauts.voxelmenus.menu.type.page;

import me.pigauts.voxelmenus.API.Menus;
import me.pigauts.voxelmenus.menu.MenuSettings;
import me.pigauts.voxelmenus.menu.widget.Icon;
import me.pigauts.voxelmenus.menu.meta.MenuMeta;
import me.pigauts.voxelmenus.menu.type.PageMenu;

public class PlayersPageMenu extends PageMenu {

    public PlayersPageMenu(String name, MenuSettings settings, int[] pageSlots, Icon[] template) {
        super(name, settings, pageSlots, template);
    }

    @Override
    public int getPages() {
        int[] slots = getPageSlots();
        int slotsPerPage = slots.length;
        var players = Menus.getMenuPlayersList();
        int totalPlayers = players.size();
        int totalPages = (int) Math.ceil((double) totalPlayers / slotsPerPage);

        return totalPages;
    }

    @Override
    public MenuMeta getMeta(int page) {
        int[] slots = getPageSlots();
        int slotsPerPage = slots.length;
        var players = Menus.getMenuPlayersList();
        int totalPlayers = players.size();
        int totalPages = (int) Math.ceil((double) totalPlayers / slotsPerPage);

        if (page < 1 || page > totalPages) {
            return null;
        }

        int startIndex = (page - 1) * slotsPerPage;
        int endIndex = Math.min(page * slotsPerPage, totalPlayers);

//        Icon[] buttons = meta.getIcons();

        for (int i = startIndex, j = 0; i < endIndex; i++, j++) {
            Icon button = new Icon(players.get(i).getPlayerHead());

//            button.setItemMeta(getTemplate().getItemMeta());

//            buttons[slots[j]] = button;
        }

        return null;
    }

}
