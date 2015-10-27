package me.ryandw11.prisonrp.gui;

import me.ryandw11.prisonrp.core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*Note really broken but does not do what I wanted.
*
*
*
*/
public class InventoryGUI implements Listener, CommandExecutor{
	
	private final Main plugin;
	
	public InventoryGUI(Main plugin){
		this.plugin = plugin;
	}
	
	
	
	
	private void openGUI(Player p){
		Inventory i =Bukkit.createInventory(null, 9, ChatColor.GOLD + "Class Select");
		
		ItemStack slot1 = new ItemStack(Material.getMaterial(plugin.getConfig().getString("slot1.item")));
		ItemMeta slot1Meta = slot1.getItemMeta();
		
		
		
		ItemStack PrisonerB = new ItemStack(Material.COAL);
		ItemMeta PrisonerBMeta = PrisonerB.getItemMeta();
		
		ItemStack PrisonerC = new ItemStack(Material.WOOD);
		ItemMeta PrisonerCMeta = PrisonerC.getItemMeta();
		
		//==========================================================
		String s1name = plugin.getConfig().getString("slot1.name");
		String s1name2 = s1name.replaceAll("&" , "§");
		slot1Meta.setDisplayName(s1name2);
		slot1.setItemMeta(slot1Meta);
		//==========================================================
		PrisonerBMeta.setDisplayName(ChatColor.GOLD + "Prisoner B");
		PrisonerB.setItemMeta(PrisonerBMeta);
		
		PrisonerCMeta.setDisplayName(ChatColor.GOLD + "Prisoner C");
		PrisonerC.setItemMeta(PrisonerCMeta);
		
		i.setItem(1, slot1);
		i.setItem(5, PrisonerB);
		i.setItem(7, PrisonerC);
		
		p.openInventory(i);
	}
	
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e){
		if(!ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Class Select"))
		return;
		Player p = (Player) e.getWhoClicked();
		e.setCancelled(true);
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()){
			p.closeInventory();
			return;
		}
		//======================================-------------------------------------====================================
		
				//=======================================------------------------------------==========================
		
			switch (e.getCurrentItem().getType()){
			
			case Material.STAINED_GLASS_PAN, 1, (short)):
				
				p.closeInventory();
				p.sendMessage(ChatColor.GREEN + "Sent Message");
				break;
				
			case COAL:
				
				p.closeInventory();
				p.sendMessage(ChatColor.GREEN + "Sent Message");
				break;
				
			case WOOD:
				
				p.closeInventory();
				p.sendMessage(ChatColor.GREEN + "Sent Message");
				break;
				
			default:
				p.closeInventory();
				break;
			}
		
}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("class")){
			if(!(p instanceof Player )) return true;
			openGUI(p.getPlayer());
		}

		return false;
		
	}
	
	
}
