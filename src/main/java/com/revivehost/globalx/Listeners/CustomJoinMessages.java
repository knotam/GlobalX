package com.revivehost.globalx.Listeners;

import com.revivehost.globalx.GlobalX;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CustomJoinMessages implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (GlobalX.instance.getConfig().getBoolean("CustomJoinMessages")) {
            String message = GlobalX.instance.getConfig().getString("CustomJoinMessages.message");
            message.replace("{player}", event.getPlayer().getDisplayName());
            message = ChatColor.translateAlternateColorCodes('&', message);
            event.setJoinMessage(message);
        }
    }
}
