/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jarry.bukkit.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class Tower {

    private CommandSender sender;
    private Command cmd;
    private String label;
    private String[] args;

    public Tower(CommandSender sender, Command cmd, String label, String[] args) {
        this.sender = sender;
        this.cmd = cmd;
        this.label = label;
        this.args = args;
    }

    public boolean doCommand() {

        // int materialNo = 46;
        int towerHeight = 20;

        /**
         * http://minecraft-ids.grahamedgecombe.com/
         */
        Material material = Material.GLOWSTONE; // Material.getMaterial(materialNo);
        int height = towerHeight;

        int x = ((Player) sender).getLocation().getBlockX();
        int y = ((Player) sender).getLocation().getBlockY();
        int z = ((Player) sender).getLocation().getBlockZ();

        int[] tower = {
            x + 1, y, z,
            x - 1, y, z,
            x, y, z + 1,
            x, y, z - 1,
            x + 1, y, z + 1,
            x - 1, y, z - 1,
            x + 1, y, z - 1,
            x - 1, y, z + 1
        };

        Block block;
        World world = ((Player) sender).getWorld();

        int l = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < tower.length; j += 3) {
                block = world.getBlockAt(tower[j], tower[j + 1] + l, tower[j + 2]);
                block.setType(material);
            }
            l++;
        }

        sender.sendMessage(ChatColor.GREEN + "You made a tower of " + material.toString() + " that is " + height + " blocks high.");
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
