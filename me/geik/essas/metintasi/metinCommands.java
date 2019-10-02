package me.geik.essas.metintasi;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class metinCommands implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public metinCommands(Main plugin) {
	    this.plugin = plugin;}
	
	@SuppressWarnings("unused")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File spawn = new File("plugins/Essas/locations/metinloc.yml");
	  	FileConfiguration loc = YamlConfiguration.loadConfiguration(spawn);
		  	if (label.equalsIgnoreCase("metinstone")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					 metinListener.metintask.cancel();
					if (player.hasPermission("essas.metin.admin")) {
						int x = loc.getInt("Location.x");
					  	int y = loc.getInt("Location.y");
					  	int z = loc.getInt("Location.z");
					  	String string = loc.getString("Location.world");
						if (metinListener.metindurumu == false) {
							 metinListener.metintask.cancel();
							metinListener.metindurumu = false;
						    try {
						    	Set<Material> NullSet = null;
						    	Block b = player.getTargetBlock(NullSet, 20);
							int playerx = b.getLocation().getBlockX();
							int playery = b.getLocation().getBlockY();
							int playerz = b.getLocation().getBlockZ();
							String playerworld = player.getLocation().getWorld().getName();
							x = playerx;
							y = playery;
							z = playerz;
							string = playerworld;
							
							loc.set("Location.x", playerx);
							loc.set("Location.y", playery);
							loc.set("Location.z", playerz);
							loc.set("Location.world", playerworld);
							try {loc.save(spawn);} catch (IOException e) {e.printStackTrace();}
							
							
							if (Main.instance.getConfig().getBoolean("metin.event") == true) {
								metinListener.metincd2();}
							
							
							paylasim.metinCordSaved(player);} catch(Exception en) {paylasim.metincmdError(player);}
						}
						else {
							metinListener.metindurumu = false;
							 metinListener.metintask.cancel();
							
							    try {
							    	Set<Material> NullSet = null;
							    	Block b = player.getTargetBlock(NullSet, 20);
								int playerx = b.getLocation().getBlockX();
								int playery = b.getLocation().getBlockY();
								int playerz = b.getLocation().getBlockZ();
								String playerworld = player.getLocation().getWorld().getName();
								x = playerx;
								y = playery;
								z = playerz;
								string = playerworld;
								
								loc.set("Location.x", playerx);
								loc.set("Location.y", playery);
								loc.set("Location.z", playerz);
								loc.set("Location.world", playerworld);
								try {loc.save(spawn);} catch (IOException e) {e.printStackTrace();}
								
								
								if (Main.instance.getConfig().getBoolean("metin.event") == true) {
									metinListener.metincd2();}
								
								paylasim.metinCordSaved(player);} catch(Exception en) {paylasim.metincmdError(player);}
						}
					} else paylasim.noPerm(player);
					
				} else paylasim.noConsole(sender);
			}

		
		return false;
	}

}
