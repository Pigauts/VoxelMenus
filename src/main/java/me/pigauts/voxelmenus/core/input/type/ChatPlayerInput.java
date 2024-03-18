package me.pigauts.voxelmenus.core.input.type;

import me.pigauts.voxelmenus.API.MenuPlayer;
import me.pigauts.voxelmenus.core.input.PlayerInput;
import me.pigauts.voxelmenus.core.input.PlayerInputListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class ChatPlayerInput { //extends PlayerInputListener implements PlayerInput {

//    @Override
//    public void collect(MenuPlayer player) {
//        inputPlayers.add(player);
//    }
//
//    @EventHandler
//    public void onChat(AsyncPlayerChatEvent event) {
//        UUID playerId = event.getPlayer().getUniqueId();
//
//        for (MenuPlayer player : inputPlayers) {
//            if (player.getUniqueId().equals(playerId)) {
//                player.receiveInput(event.getMessage());
//                return;
//            }
//        }
//    }

}
