package com.revivehost.globalx.Listeners;

import com.revivehost.globalx.GlobalX;
import org.apache.commons.lang.time.DateUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Calendar;

public class DeathBans implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (GlobalX.instance.getConfig().getBoolean("DeathBans")) {
            // KNOTAM DID THIS PART WOW
            Player p = event.getEntity();
            Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(), "8 hour death ban.", DateUtils.addHours(Calendar.getInstance().getTime(), 8), "Server");
            p.kickPlayer("You have been banned for dying. Please rejoin in 8 hours.");
            event.setDeathMessage("[GlobalX] " + p.getName() + ChatColor.RED + " Has been banned for 8 hours for dying!");
        }
    }
}
