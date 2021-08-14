package dev.essung.pvp_plugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class PvpPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        getCommand("challenge").setExecutor(new Commands(new ArrayList<>()));
        getLogger().info("onEnable is called!");
    }

    @EventHandler
    public void onPlayerLoad(PlayerJoinEvent event) {
        event.getPlayer().getInventory().addItem(new ItemStack(Material.BOW, 1));
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
