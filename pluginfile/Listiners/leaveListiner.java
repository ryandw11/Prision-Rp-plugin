package me.ryandw11.prisonrp.Listners;

import me.ryandw11.prisonrp.commands.riotCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class leaveListner implements Listener{

	@EventHandler
	public void onLeave(PlayerQuitEvent event){
		Player p = (Player) event.getPlayer();
		if(riotCommand.Riot[0].equals("True") && riotCommand.Riot[1].equals(p.getDisplayName())){
			riotCommand.Riot[0] = "False";
			riotCommand.Riot[1] = "Null";
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "[Riot]" +ChatColor.RED + "The riot starter: " + ChatColor.GOLD + p.getDisplayName() + ChatColor.RED + " has left the game so the riot is canclled!");
		}
		
		
	}


}


