package me.geik.essas.maincommands;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.chatevent.chatEvent;
import me.geik.essas.language.LangCreator;
import me.geik.essas.location.LocationsCreator;
import me.geik.essas.metintasi.metinListener;
import me.geik.essas.permantKit.adakitfolder;

public class Voids {
	
	public static void giveallExecute(CommandSender sender, String[] args) {
		String[] newPi = args;
		newPi = removeElements(newPi, newPi[0]);
		String newCMD = convertArrayToStringUsingStreamAPI(newPi);
		for(Player p : Bukkit.getOnlinePlayers()){
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), newCMD.replace("&", "§").replace("%player%", p.getName()));}
		paylasim.giveallExecuted(sender);
		sender.sendMessage(newCMD);
	}
	public static void chatEventAgain(CommandSender player) {
			if (chatEvent.basladi != null) {
				paylasim.chateventAlreadyRunningevent(player);
			}else {
				chatEvent.donguid.cancel();
				chatEvent.ChatEventBaslat();
				paylasim.chatEventAgainRepet(player);
			}
	}
	public static void help(CommandSender player) {
		for (String help : paylasim.fc.getStringList("Plugin.help")) {
			player.sendMessage(paylasim.color(help));
		}
	}
	public static void metinagain(CommandSender sender) {
		if (metinListener.metindurumu == false) {
			int x = metinListener.loc.getInt("Location.x");
		  	int y = metinListener. loc.getInt("Location.y");
		  	int z =  metinListener.loc.getInt("Location.z");
		  	String string =  metinListener.loc.getString("Location.world");
		  	World world = Bukkit.getServer().getWorld(string);
		  if (world != null) {
			Location tas = new Location(world, x, y, z);
			String materialx = paylasim.cfg.getString("metin.metin-material");
			
			metinListener.can = metinListener.defaultcan;
			tas.getBlock().setType(Material.getMaterial(materialx));
			metinListener.metindurumu = true;
			if (paylasim.cfg.getBoolean("metin.respawned-again-broadcast") == true) paylasim.metinStoneBroadcast();
			metinListener.metintask.cancel();
		  } else paylasim.metinTasNo(sender);
		} else {
			paylasim.metinAlreadyRunning(sender);
		}
	}
	@SuppressWarnings("deprecation")
	public static void reloadConfig(CommandSender sender) {
		File metine = new File("plugins/Essas/locations/metinloc.yml");
	  	FileConfiguration loc = YamlConfiguration.loadConfiguration(metine);
	  	File xx = new File("plugins/Essas/locations/voidspawn.yml");
	  	FileConfiguration xxx = YamlConfiguration.loadConfiguration(xx);
		try {LocationsCreator.locationFile();} catch (IOException e) {e.printStackTrace();}
		try {adakitfolder.alanlarKurulum();} catch (IOException e) {e.printStackTrace();}
		try {paylasim.fc.save(paylasim.f);} catch (IOException e1) {e1.printStackTrace();}
		try {xxx.save(xx);} catch (IOException e1) {e1.printStackTrace();}
		try {loc.save(metine);} catch (IOException e1) {e1.printStackTrace();}
		metinListener.metintask.cancel();
		try {LocationsCreator.locationFile();} catch (IOException e) {e.printStackTrace();}
		try {adakitfolder.alanlarKurulum();} catch (IOException e) {e.printStackTrace();}
		LangCreator.LangChecker();
		File configFile = new File(Main.instance.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			Main.instance.saveDefaultConfig();}
		Main.instance.reloadConfig();
		
		
		Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				paylasim.langName = paylasim.cfg.getString("lang");
				metinListener.metindurumu = false;
				if (Main.instance.getConfig().getBoolean("metin.event") == true) {
					metinListener.metincd2();}
				if (Main.instance.getConfig().getBoolean("chat-event.events") == true) {
					chatEvent.ChatEventBaslat();}
				Main.globalmute = false;
				paylasim.reloadCmd(sender);
				
				if (paylasim.cfg.getBoolean("metin.event") == true) {
					Bukkit.getServer().getConsoleSender().sendMessage(paylasim.color("&a&lESSAS &aMetinStone feature is &lENABLED"));
				}
				else {
					Bukkit.getServer().getConsoleSender().sendMessage(paylasim.color("&c&lESSAS &cMetinStone feature is &cDISABLED"));
				}
				if (paylasim.cfg.getBoolean("chat-event.events") == true) {
					Bukkit.getServer().getConsoleSender().sendMessage(paylasim.color("&a&lESSAS &aChatEvent feature is &lENABLED"));
				}else {
					Bukkit.getServer().getConsoleSender().sendMessage(paylasim.color("&c&lESSAS &cChatEvent feature is &cDISABLED"));
				}
			}
		},20);
		
		
	}
	public static String[] removeElements(String[] arr, String key) 
    { 
          int index = 0; 
          for (int i=0; i<arr.length; i++) 
             if (arr[i] != key) 
                arr[index++] = arr[i]; 
         return Arrays.copyOf(arr, index); 
    }
	public static String convertArrayToStringUsingStreamAPI(String[] strArray) {
        String joinedString = String.join(" ", strArray);
        return joinedString;
    }

}
