package com.revivehost.globalx.Listeners;

import com.revivehost.globalx.GlobalX;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class CustomLeaveMessages implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (GlobalX.instance.getConfig().getBoolean("CustomLeaveMessages")) {
            String message = GlobalX.instance.getConfig().getString("CustomLeaveMessages.message");
            message.replace("{player}", event.getPlayer().getDisplayName());
            message = ChatColor.translateAlternateColorCodes('&', message);
            event.setQuitMessage(message);
        }
    }
}
