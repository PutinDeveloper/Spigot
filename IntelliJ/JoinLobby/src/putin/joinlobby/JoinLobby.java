package putin.joinlobby;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinLobby extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){ getServer().getPluginManager().registerEvents(this, this); }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1.0f, 1.0f);

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        if (p.hasPlayedBefore()){
            p.sendMessage(p.getName() + ChatColor.GREEN +" joined the lobby!");
        } else{
            p.sendMessage("Welcome back, " + p.getName());
        }
    }
}