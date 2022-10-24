package me.connor.quantekk;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.java.JavaPlugin;

public class dupes extends JavaPlugin
  implements Listener
{
  @EventHandler
  public void handleDupes(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    int slot = event.getSlot();
    String title = event.getView().getTopInventory().getTitle().toLowerCase();

    if (title.equals("rm furnace")) {
      if ((slot == 35) && (event.isShiftClick())) {
        event.setCancelled(true);
        player.sendMessage(main.xC + ChatColor.RED + "You cant DUPE with an RM_Furnace");
      }
    }
    else if (title.equals("tank cart")) {
      if (event.isShiftClick()) {
        event.setCancelled(true);
        player.sendMessage(main.xC + ChatColor.RED + "You cant DUPE with an TANK_CART");
      }
    } else if ((title.equals("trans tablet")) && 
      (event.isShiftClick())) {
      boolean isslot = (slot == 0) || (slot == 1) || (slot == 2) || (slot == 3) || (slot == 4) || (slot == 5) || (slot == 6) || (slot == 7);
      if (isslot) {
        event.setCancelled(true);
        player.sendMessage(main.xC + ChatColor.RED + "You cant SHIFT + Click within a Trans Tablet");
      }
    }
  }
}