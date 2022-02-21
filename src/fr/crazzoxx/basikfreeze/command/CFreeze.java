package fr.crazzoxx.basikfreeze.command;

import fr.crazzoxx.basikfreeze.BasikFreeze;
import fr.crazzoxx.basikfreeze.inventory.InventoryFreeze;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CFreeze implements CommandExecutor {
private BasikFreeze instance;
public CFreeze(){
    instance = BasikFreeze.getInstance();
}
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length == 0)
            return false;
        boolean connected = false;
        if(args.length == 1){
            Player target = Bukkit.getPlayer(args[0]);
            for(Player player : instance.getServer().getOnlinePlayers()){
                if(player.equals(target)){
                    if(instance.getFreezedPlayer().contains(player)){
                        instance.getFreezedPlayer().remove(player);
                        player.sendMessage(instance.getConfStr("message.player-unfreeze"));
                        sender.sendMessage(instance.getConfStr("message.staff-unfreeze-player").replace("{player}", args[0]));
                        target.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
                        return true;
                    }else {
                        instance.getFreezedPlayer().add(player);
                        player.sendMessage(instance.getConfStr("message.player-freeze"));

                        target.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,100000000,10));
                        sender.sendMessage(instance.getConfStr("message.staff-freeze-player").replace("{player}", args[0]));
                        //target.openInventory(new InventoryFreeze().openFreezeInventory());
                        return true;
                    }
                }
            }
            return false;
            // target.openInventory(new InventoryFreeze().openFreezeInventory());
        }
        return false;
    }
}
