package dk.jarry.bukkit;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Michael Bornholdt Nielsen <mni@jarry.dk>
 */
public class JarryPlugin extends JavaPlugin {

    private final JarryCommandExecutor commandExecutor = new JarryCommandExecutor(this);

    @Override
    public void onDisable() {
    }

    @Override
    public void onEnable() {

        PluginManager pm = this.getServer().getPluginManager();

        getCommand("jarrycommand").setExecutor(commandExecutor);

        pm.registerEvents(new SendMsgToPlayerPlayerMoveListener(this), this);
        pm.registerEvents(new SendMsgToAllPlayersBlockListener(this), this);
        pm.registerEvents(new SendMsgToPlayerBlockListener(this), this);
        pm.registerEvents(new CancelDamageEntityDamageListener(this), this);

    }
    
}
