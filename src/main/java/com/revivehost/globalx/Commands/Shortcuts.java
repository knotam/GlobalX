package com.revivehost.globalx.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shortcuts {
    public static class GamemodeCreative implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");
            }

            Player p = (Player) sender;
            if (canExecute(p)) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.GREEN + "Set gamemode to creative");
            }
            return true;
        }
    }

    public static class GamemodeSurvival implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");
            }

            Player p = (Player) sender;
            if (canExecute(p)) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.GREEN + "Set gamemode to survival");
            }
            return true;
        }
    }

    public static boolean canExecute(Player player) {
        if (player.hasPermission("bukkit.command.gamemode")) {
            return true;
        }
        player.sendMessage(ChatColor.RED + "You don't have the correct permissions!");
        return false;
    }

}
