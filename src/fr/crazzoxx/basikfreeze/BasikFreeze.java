package fr.crazzoxx.basikfreeze;

import fr.crazzoxx.basikfreeze.command.CFreeze;
import fr.crazzoxx.basikfreeze.listener.PlayerFreezeEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BasikFreeze extends JavaPlugin {
    private Logger log = Logger.getLogger("Minecraft");
    private static BasikFreeze instance;
    private List<Player> freezedPlayer;

    @Override
    public void onEnable() {
         saveDefaultConfig();
         instance = this;
         if(!getConfig().getBoolean("plugin.enable")) {
             log.severe("plugin disabled in config.yml");
             getServer().getPluginManager().disablePlugin(this);
         }
         else {
             getCommand("bfreeze").setExecutor(new CFreeze());
             freezedPlayer = new ArrayList<Player>();
             getServer().getPluginManager().registerEvents(new PlayerFreezeEvent(),this);
         }

    }
    @Override
    public void onDisable() {

    }
    public static BasikFreeze getInstance(){
        return instance;
    }
    public List<Player> getFreezedPlayer() {
        return freezedPlayer;
    }
    public String getConfStr(String confPath){return getConfig().getString(confPath).replace("&","§");}
}
