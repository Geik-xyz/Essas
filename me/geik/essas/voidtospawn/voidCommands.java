package me.geik.essas.voidtospawn;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class voidCommands implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public voidCommands(Main plugin) {
	    this.plugin = plugin;}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File spawn = new File("plugins/Essas/locations/voidspawn.yml");
	  	FileConfiguration loc = YamlConfiguration.loadConfiguration(spawn);
		if (label.equalsIgnoreCase("voidtospawn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("essas.void.admin")) {
					double playerx = player.getLocation().getX();
					double playery = player.getLocation().getY();
					double playerz = player.getLocation().getZ();
					double playerpitch = player.getLocation().getPitch();
					double playeryaw = player.getLocation().getYaw();
					String playerworld = player.getLocation().getWorld().getName();
					
					loc.set("Location.x", playerx);
					loc.set("Location.y", playery);
					loc.set("Location.z", playerz);
					loc.set("Location.pitch", playerpitch);
					loc.set("Location.yaw", playeryaw);
					loc.set("Location.world", playerworld);
					try {loc.save(spawn);} catch (IOException e) {e.printStackTrace();}
					
					paylasim.voidSpawnSaved(player);

				} else paylasim.noPerm(player);
			} else paylasim.noConsole(sender);
		}
		
		
		return false;
	}
	
	
}
