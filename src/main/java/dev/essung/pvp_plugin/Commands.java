package dev.essung.pvp_plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

//spelare skickar request
//spelare och andra spelare blir lagd i en lista
//om spelaren acceptar tas dem bort och tpas till en arena

public class Commands implements CommandExecutor {
    ArrayList<Lobby> lobbies;

    public Commands(ArrayList<Lobby> lobbies) {
        this.lobbies = lobbies;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) { return true; }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("challenge")) {
            if (args.length > 0) {
                player.sendMessage("arg1 is: " + args[0]);

                if (args[0].equalsIgnoreCase("accept")) {
                    for (Lobby lobby: lobbies) {
                        if (lobby.player1.getName().equalsIgnoreCase(args[1])) {
                            initPvp(lobby);
                        }
                    }
                    return true;
                }

                Player otherPlayer = Bukkit.getPlayer(args[0]);
                otherPlayer.chat("Do you wanna pvp: " + player.getName());
                lobbies.add(new Lobby(player, otherPlayer));

                return true;
            }
        }

        return true;
    }

    public void initPvp(Lobby lobby) {
        lobby.player1.sendMessage("initiated pvp!");
    }
}
