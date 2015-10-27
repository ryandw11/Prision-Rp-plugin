package me.ryandw11.prisonrp.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class riotCommand implements CommandExecutor, Listener{

	//Error: riotCMD.No_OutPut.Else
	
    public static String[] Riot = new String[] {"False", "Null" };
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		
		Player p = (Player) sender;
		if(!(sender instanceof Player)) return true;
		if(!(args.length == 1)){
			
		
		
		
		if(Riot[0].equals("False")){
			Riot[0] = "True";
			Riot[1] = p.getDisplayName();
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[Riot]" +ChatColor.RED + "A riot has been started by: " + ChatColor.GOLD + p.getDisplayName() + ChatColor.RED + "!");
		}
		else if(Riot[0].equals("True") && Riot[1].equals(p.getDisplayName())){
			Riot[0] = "False";
			Riot[1] = "Null";
			p.sendMessage(ChatColor.RED + "Riot Stopped");
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[Riot]" +ChatColor.RED + "The riot has been canclled!");
			
		}
		else if(Riot[0].equals("True") && !(Riot[1].equals(p.getDisplayName()))){
			p.sendMessage(ChatColor.RED + "A riot is already going on! You may not stop the riot!");
		}
		else{
			p.sendMessage("A fatal error has occuried! Please contact the server owner! Error: riotCMD.No_OutPut.Else");
		}
		
			
		}
		else{
			if(args[0].equalsIgnoreCase("stop")){
				if(p.hasPermission("prisonrp.riot.stop") || p.isOp()){
					Riot[0] = "False";
					Riot[1] = "Null";
					p.sendMessage(ChatColor.GREEN + "Riot stopped");
					Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[Riot]" +ChatColor.RED + "The riot has been stopped by a Staff Member!");
				}
				else{
					p.sendMessage(ChatColor.RED + "You do not have permission for this command. To stop a riot ask a staff member!");
				}
			}
			else{
				p.sendMessage(ChatColor.RED + "Unknown sub-command. Ussage: /riot");
			}
		}

		
		return false;
	}
	
	}
