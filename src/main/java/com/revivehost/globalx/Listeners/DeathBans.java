package com.revivehost.globalx.Listeners;

import com.revivehost.globalx.GlobalX;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathBans implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (GlobalX.instance.getConfig().getBoolean("DeathBans")) {
            Bukkit.getBanList(BanList.Type.NAME).addBan(event.getEntity().getName(), ChatColor.RED + "You have been eliminated!", null, "Console");
            event.getEntity().kickPlayer(ChatColor.RED + "You have been eliminated!");
        }
    }
}
