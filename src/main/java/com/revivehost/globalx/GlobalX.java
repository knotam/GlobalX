package com.revivehost.globalx;

import com.revivehost.globalx.Commands.Shortcuts;
import com.revivehost.globalx.Listeners.CustomJoinMessages;
import com.revivehost.globalx.Listeners.CustomLeaveMessages;
import com.revivehost.globalx.Listeners.DeathBans;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class GlobalX extends JavaPlugin {
    public static Logger logger;
    public static JavaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();
        logger.info(ChatColor.GREEN + "GlobalX is starting...");

        loadConfig();

        addListeners(
                new CustomJoinMessages(),
                new CustomLeaveMessages(),
                new DeathBans()
        );

        getCommand("gmc").setExecutor(new Shortcuts.GamemodeCreative());
        getCommand("gms").setExecutor(new Shortcuts.GamemodeSurvival());
    }

    @Override
    public void onDisable() {
        logger.info(ChatColor.RED + "GlobalX is disabling...");
    }

    private void loadConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
    }

    private void addListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
}
