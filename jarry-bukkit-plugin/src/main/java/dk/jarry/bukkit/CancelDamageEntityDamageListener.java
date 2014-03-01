package dk.jarry.bukkit;

import dk.jarry.bukkit.JarryPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * http://pastebin.com/8UZ6pkWC
 *
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class CancelDamageEntityDamageListener implements Listener {

    public JarryPlugin plugin;

    public CancelDamageEntityDamageListener(JarryPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {

        if (event.getEntity() instanceof Player) {
            //If the entity being damaged is a player then...

            event.setCancelled(true);
            //Cancel the damage event, this will give the player unlimited health
        }
    }

    
}
