package dk.jarry.bukkit;

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
        plugin.getLogger().info("onCommand Reached in JarryCommandExecutor");

        if (command.getName().equalsIgnoreCase("jarrycommand")) {
	    plugin.getLogger().info("jarrycommand used");
            //do something
            return true;
        }
        return false;
    }
    
}
