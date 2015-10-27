package me.ryandw11.prisonrp.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class advertCommand implements CommandExecutor {

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		Player p = (Player) sender;
		if(!(sender instanceof Player)) return true;
		if(cmd.getName().equalsIgnoreCase("advert")){
			if(!(args.length == 1)){
				p.sendMessage(ChatColor.RED + "Ussage: " + ChatColor.GOLD + "/advert (message)");
			}
			else{
				
			
			String name = p.getDisplayName();
			String Message = "";
			for (int i = 0; i < args.length; i++){
				Message = Message + " " + args[i];
				
			}
			Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "[Advert]" + ChatColor.RED + name + ChatColor.GOLD + ":"  + Message);
			//Arrays.toString(args)
			}
		}
		return false;
	}

}
