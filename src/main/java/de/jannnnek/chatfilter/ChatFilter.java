package de.jannnnek.chatfilter;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ChatFilter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player player = e.getPlayer();
        List<String> forbidden = this.getConfig().getStringList("forbidden");
        for (String s: forbidden) {
            if (message.contains(s)) {
                e.setCancelled(true);
                if (this.getConfig().getBoolean("show-message")) {
                    StringBuilder replace = new StringBuilder();
                    for (int i=0; i < s.length(); i++) {
                        replace.append("*");
                    }
                    for (Player player1 : Bukkit.getOnlinePlayers()) {
                        player1.sendMessage(player.getDisplayName() + " §8: §7" + message.replace(s, replace.toString()));
                    }
                } else {
                    player.sendMessage(this.getConfig().getString("prefix") + this.getConfig().getString("rejected-message"));
                }
            }
        }
    }
}
