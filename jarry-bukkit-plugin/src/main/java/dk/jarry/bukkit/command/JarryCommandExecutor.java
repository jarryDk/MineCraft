package dk.jarry.bukkit.command;

import dk.jarry.bukkit.JarryPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class JarryCommandExecutor implements CommandExecutor {
    
    private JarryPlugin plugin;

    public JarryCommandExecutor(JarryPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        plugin.getLogger().info("onCommand Reached in JarryExecutor");

        if (command.getName().equalsIgnoreCase("jarry")) {
	    plugin.getLogger().info("jarry used");
            
            String arg0 = null;
            
            if( args.length > 0 && args[0] != null){
                arg0 = args[0].toUpperCase();
                switch (arg0) {
                    case "VERSION":
                        sender.sendMessage("Version : " + JarryPlugin.VERSION);
                        break;
                    case "AUTHOR":
                        sender.sendMessage("AUTHOR : " + JarryPlugin.AUTHOR);
                        break;
                    case "TOWER":
                        Tower tower = new Tower(sender, command, label, args);
                        tower.doCommand();
                        break;
                    case "TPALL":
                        TeleportAll tpAll = new TeleportAll(sender, command, label, args);
                        tpAll.doCommand();
                        break;
                }
            }else{
                 sender.sendMessage("Usage: /jarry version");
                 sender.sendMessage("Usage: /jarry author");
                 sender.sendMessage("Usage: /jarry tower");
                 sender.sendMessage("Usage: /jarry tpall");
            }
            return true;
        }
        
        return false;
    }
    
}
