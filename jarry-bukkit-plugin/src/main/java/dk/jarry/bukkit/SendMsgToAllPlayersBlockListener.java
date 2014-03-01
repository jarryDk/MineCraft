package dk.jarry.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class SendMsgToAllPlayersBlockListener implements Listener {

    private JarryPlugin plugin;

    public SendMsgToAllPlayersBlockListener(JarryPlugin plugin) {
        this.plugin = plugin;
    }

    // http://jd.bukkit.org/apidocs/ provide a complete list of events that can be registered.

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Bukkit.getServer().broadcastMessage("Player " + event.getPlayer().getName() + " placed " + event.getBlock().getType() + " at " + event.getBlock().getLocation());
    }
    
}
