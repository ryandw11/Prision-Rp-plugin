package me.ryandw11.prisonrp.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import me.ryandw11.prisonrp.Listners.clickListner;


import me.ryandw11.prisonrp.Listners.leaveListner;
import me.ryandw11.prisonrp.commands.advertCommand;
import me.ryandw11.prisonrp.commands.lockpickCommand;



import me.ryandw11.prisonrp.commands.riotCommand;
import me.ryandw11.prisonrp.gui.InventoryGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	
//	public File config = new File(getDataFolder() + "/config.yml");
//	public FileConfiguration rpconfig = YamlConfiguration.loadConfiguration(config);
	
	public static Material slot1item = Material.getMaterial(plugin.getConfig().getString("slot1.item"));
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("The PrisonRP plugin has been enabled and is ready for RP!"); // prints into the log
		Bukkit.getServer().getPluginManager().registerEvents(new clickListner(), this);
		getCommand("lockpick").setExecutor(new lockpickCommand());
		getCommand("advert").setExecutor(new advertCommand());
		getCommand("riot").setExecutor(new riotCommand());
		getCommand("class").setExecutor(new InventoryGUI(plugin));
		
		//loadFiles();
		
		this.saveDefaultConfig();
		
		Bukkit.getServer().getPluginManager().registerEvents(new leaveListner(), this);
		//getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getPluginManager().registerEvents(new InventoryGUI(plugin), this);
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("The PrisonRP plugin has been disabled!"); // same thing
		//saveFiles();
		
	}
	
	//Data methods below! VVVVVV
	
//	public void saveFiles(){           // save the files
//		try {
//			rpconfig.save(config);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}//end of save files
//	
//	
//	public void loadFiles(){
//		if(config.exists()){
//			try {
//				rpconfig.load(config);
//			} catch (IOException | InvalidConfigurationException e) {
//				e.printStackTrace();
//			}
//		}//end of if
//		else{
//			try {
//				rpconfig.save(config);
//				preConfig();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}//end of else
//	}//end of load file
//	
//	public void preConfig(){
//		//warp:
//		rpconfig.set("warp", "prison");
//		
//		//slot1:
//		rpconfig.set("slot1.name", "Prisoner A");
//		rpconfig.set("slot1.color", "Gold");
//		rpconfig.set("slot1.kit" , "PrisonerA");
//		rpconfig.set("slot1.item" , "35:1");
//
//
//		//slot2:
//		rpconfig.set("slot2.name", "Prisoner B");
//		rpconfig.set("slot2.color", "Gold");
//		rpconfig.set("slot2.kit" , "PrisonerB");
//		rpconfig.set("slot2.item" , "35:2");
//	
//		//slot3:
//		rpconfig.set("slot3.name", "Prisoner C");
//		rpconfig.set("slot3.color", "Gold");
//		rpconfig.set("slot3.kit" , "PrisonerC");
//		rpconfig.set("slot3.item" , "35:3");
//		
//		//slot4:
//		rpconfig.set("slot4.name", "Change in Config");
//		rpconfig.set("slot4.color", "Red");
//		rpconfig.set("slot4.kit" , "PrisonerA");
//		rpconfig.set("slot4.item" , "35:14");
//		
//		//slot5:
//		rpconfig.set("slot5.name", "Change in Config");
//		rpconfig.set("slot5.color", "Red");
//		rpconfig.set("slot5.kit" , "PrisonerA");
//		rpconfig.set("slot5.item" , "35:14");
//		
//		//slot6:
//		rpconfig.set("slot6.name", "Change in Config");
//		rpconfig.set("slot6.color", "Red");
//		rpconfig.set("slot6.kit" , "PrisonerA");
//		rpconfig.set("slot6.item" , "35:14");
//		
//		//slot7:
//		rpconfig.set("slot7.name", "Change in Config");
//		rpconfig.set("slot7.color", "Red");
//		rpconfig.set("slot7.kit" , "PrisonerA");
//		rpconfig.set("slot7.item" , "35:14");
//		
//		//slot8:
//		rpconfig.set("slot8.name", "Change in Config");
//		rpconfig.set("slot8.color", "Red");
//		rpconfig.set("slot8.kit" , "PrisonerA");
//		rpconfig.set("slot8.item" , "35:14");
//		
//		//slot9:
//		rpconfig.set("slot9.name", "Change in Config");
//		rpconfig.set("slot9.color", "Red");
//		rpconfig.set("slot9.kit" , "PrisonerA");
//		rpconfig.set("slot9.item" , "35:14");
//		
//		try {
//			rpconfig.save(config);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	

	
	
	
}
