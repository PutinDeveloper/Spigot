package putin.playerevent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.Action;

import javax.swing.*;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        Action a = e.getAction();
        if(a == Action.RIGHT_CLICK_AIR && Action.RIGHT_CLICK_BLOCK){
            if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.COMPASS){
                Inventory i = Bukkit.createInventory(null,9,"Teleport");
                ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + "Teleport");
                item.setItemMeta(meta);
                i.setItem(8, item);
                e.getPlayer().openInventory(i);
            }
        }
    }

    @EventHandler
    public void onInventory(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        if(event.getClickedInventory().getName().equals("Teleport")){

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Teleport"))
                p.sendMessage(ChatColor.AQUA + "Teleported");
            }
        }
    }
