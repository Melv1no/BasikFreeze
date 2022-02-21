package fr.crazzoxx.basikfreeze.listener;

import fr.crazzoxx.basikfreeze.BasikFreeze;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class PlayerFreezeEvent implements Listener {

    private BasikFreeze instance;
    public PlayerFreezeEvent(){
        instance = BasikFreeze.getInstance();
    }
    @EventHandler
    public void onPlayerFreezeEvent(PlayerMoveEvent pme){
        boolean fly = false;
        if(instance.getFreezedPlayer().contains(pme.getPlayer())){
            pme.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerFreezeEvent(EntityDamageByEntityEvent e){
        if(e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();
            if(instance.getFreezedPlayer().contains(player)){
                e.setCancelled(true);
            }
        }else if(e.getDamager() instanceof Player){
            Player player = (Player) e.getDamager();
            if(instance.getFreezedPlayer().contains(player)){
                e.setCancelled(true);
            }
        }
    }

    }


