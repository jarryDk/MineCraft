package dk.jarry.bukkit;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * http://pastebin.com/MTwaAVCT
 *
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class SendMsgToPlayerPlayerMoveListener implements Listener {

    private JarryPlugin plugin;

    public SendMsgToPlayerPlayerMoveListener(JarryPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location playerLoc = player.getLocation();
        player.sendMessage("Your X Coordinates : " + playerLoc.getX());
        player.sendMessage("Your Y Coordinates : " + playerLoc.getY());
        player.sendMessage("Your Z Coordinates : " + playerLoc.getZ());
    }

}
