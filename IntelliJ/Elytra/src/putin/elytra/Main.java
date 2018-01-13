package putin.elytra;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onSprint(PlayerToggleSprintEvent event){
        Player p = event.getPlayer();
        Location l = p.getLocation();

        if (p.isSprinting()){
            p.setVelocity(p.getLocation().getDirection().multiply(1.0f));
        }
    }
}
