package dev.essung.pvp_plugin;

import org.bukkit.entity.Player;

public class Lobby {
    public Player player1;
    public Player player2;

    public Lobby(Player player1, Player player2 ) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
