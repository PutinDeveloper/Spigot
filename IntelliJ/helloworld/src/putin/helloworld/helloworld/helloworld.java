package putin.helloworld.helloworld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class helloworld extends JavaPlugin{

    public void onEnable(){

        getLogger().info("Hello world!");
    }

    public boolean onCommand(CommandSender sender,Command cmd,String label, String[]args){

        if(cmd.getName()==("memes"))
        {
        if(sender instanceof Player){
            sender.sendMessage(ChatColor.BOLD + "This is a "  + ChatColor.RED + "meme");
        }
        else{
            sender.sendMessage("You are not a player silly boi!");
        }
        }
        return true;
    }
}
