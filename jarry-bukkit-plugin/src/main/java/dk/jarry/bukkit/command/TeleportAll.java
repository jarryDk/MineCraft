/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jarry.bukkit.command;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 *
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class TeleportAll {

    private CommandSender sender;
    private Command cmd;
    private String label;
    private String[] args;

    public TeleportAll(CommandSender sender, Command cmd, String label, String[] args) {
        this.sender = sender;
        this.cmd = cmd;
        this.label = label;
        this.args = args;
    }

    public boolean doCommand() {

        Location location = ((Player) sender).getLocation();
        List<Player> players = location.getWorld().getPlayers();

        Location newLoc;
        for (Player player : players) {

            player.teleport(location, PlayerTeleportEvent.TeleportCause.COMMAND);

            newLoc = player.getLocation();
            player.sendMessage("Your new location X: " + newLoc.getX() + " Y: " + newLoc.getY() + " Z: " + newLoc.getZ());

        }

        return true;
    }

    public CommandSender getSender() {
        return sender;
    }

    public void setSender(CommandSender sender) {
        this.sender = sender;
    }

    public Command getCmd() {
        return cmd;
    }

    public void setCmd(Command cmd) {
        this.cmd = cmd;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

}
