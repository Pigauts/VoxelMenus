package me.pigauts.voxelmenus.command.subordinate;

import me.pigauts.voxelmenus.VoxelMenusPlugin;
import me.pigauts.voxelmenus.user.MenuPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;

public abstract class UserCommand implements SubCommand {

    protected static final VoxelMenusPlugin plugin = VoxelMenusPlugin.get();

    public final boolean canBeExecutedByConsole() {
        return false;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        MenuPlayer user = plugin.getUsers().getUser((HumanEntity) sender);
        if (user == null) return;
        this.execute(user, args);
    }

    public abstract void execute(MenuPlayer user, String[] args);

}
