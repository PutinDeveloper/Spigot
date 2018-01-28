package putin.setspawn;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            //Store the players location data into a config.yml
            getConfig().set("spawn.world", p.getLocation().getWorld().getName());
            getConfig().set("spawn.x", p.getLocation().getX());
            getConfig().set("spawn.y", p.getLocation().getY());
            getConfig().set("spawn.z", p.getLocation().getZ());
            saveConfig();
            /*
            spawn:
              world: (WORLD_NAME)
              x: (COORDINATE)
              y: (COORDINATE)
              z: (COORDINATE)
             */
            p.sendMessage(ChatColor.GREEN + "Server spawn going has been set!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("spawn")) {
            //Check to see if the spawn has been set or not
            if (getConfig().getConfigurationSection("spawn") == null) {
                p.sendMessage(ChatColor.RED + "The spawn has not been set yet!");
                return true;
            }
            //Get the data from the string: spawn - and teleport the player to it
            World world = Bukkit.getServer().getWorld(getConfig().getString("spawn.world"));
            double x = getConfig().getDouble("spawn.x");
            double y = getConfig().getDouble("spawn.y");
            double z = getConfig().getDouble("spawn.z");
            p.teleport(new Location(world, x, y, z));
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 10, 1);
            p.sendMessage(ChatColor.GREEN + "Teleported to the server spawnpoint successfully!");
        }
        return true;
    }

}