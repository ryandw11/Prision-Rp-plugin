package me.ryandw11.prisonrp.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class lockpickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

		
		if(cmd.getName().equalsIgnoreCase("lockpick")){
			
			Player p = (Player) sender;
			List<String> lores = new ArrayList<String>();
			lores.add("§aLockpick a door! (Only works on Iron!)");
			ItemStack myItem = new ItemStack(Material.BLAZE_ROD);  //your item
			ItemMeta im = myItem.getItemMeta(); //get the itemmeta of the item
			im.setDisplayName("§c§lLockPick"); //set the displayname
			myItem.setItemMeta(im); //give the item the new itemmeta
			im.setLore(lores);
			myItem.setItemMeta(im);
			p.getInventory().addItem(myItem);
			p.sendMessage(ChatColor.GREEN + "You have recived the lockpick!");
		}
		return false;
	}

}
