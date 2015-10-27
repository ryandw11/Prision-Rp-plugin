package me.ryandw11.prisonrp.Listners;

import me.ryandw11.prisonrp.core.Main;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Door;

public class clickListner implements Listener{

	public Main plugin;
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event){
		Block clicked = event.getClickedBlock();
	    Player p = event.getPlayer();
	    if(p.getItemInHand().getType() == Material.BLAZE_ROD && event.getClickedBlock().getType() == Material.IRON_DOOR_BLOCK){  
	    	p.sendMessage(ChatColor.GREEN + "LockPick Sucessful");
            BlockState state = clicked.getState();
            Door door = (Door) state.getData();
            door.setOpen(true);
            state.update();
            
	    
	   
            }
	    }
	}
	
