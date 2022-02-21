package fr.crazzoxx.basikfreeze.inventory;

import fr.crazzoxx.basikfreeze.BasikFreeze;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryFreeze {

    private BasikFreeze instance;
    public InventoryFreeze(){
        instance = BasikFreeze.getInstance();
    }
    private Inventory freezeInventory;
    public Inventory openFreezeInventory(){

        freezeInventory = Bukkit.createInventory(null,9,instance.getConfStr("gui.title"));
        addInventoryItems(freezeInventory);
        return freezeInventory;
    }
   public void addInventoryItems(Inventory inv){

    }

}
