package me.geik.essas.permantKit;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class adakit implements CommandExecutor{
	private Main plugin;
	public adakit(Main plugin) {
	    this.plugin = plugin;}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  if(label.equalsIgnoreCase("pkit")){
		  
		  
			File adakit = new File("plugins/Essas/pkit/players.yml");
		  	FileConfiguration alanlar = YamlConfiguration.loadConfiguration(adakit);
		  	File adakitip = new File("plugins/Essas/pkit/playerIPs.yml");
		  	FileConfiguration alanlarip = YamlConfiguration.loadConfiguration(adakit);
			Player player = (Player) sender;
			List<String> hasPack = new ArrayList<String>();
			hasPack.addAll(alanlar.getStringList("Takes"));
			// ip
			InetAddress pip = player.getAddress().getAddress();
			String pi = pip.toString().replace("/", "");
			List<String> hasPack2 = new ArrayList<String>();
			hasPack2.addAll(alanlarip.getStringList("Takes"));

			
		   if (plugin.getConfig().getBoolean("permantKit.enable-kit") == true){
		    if (sender instanceof ConsoleCommandSender) paylasim.noConsole(sender);
		    else {
		      if (hasPack.contains(player.getName()) || hasPack2.contains(pi)) {
			      if (player.hasPermission("essas.pkit.admin")){
			        paylasim.adakityeniAlan(player);
				  	  kitver(player);
				  	  paylasim.pkitdebug(player);
				  	paylasim.debugSomethng("&b" + player.getName() + " &cTake pKit with admin perm: &eessas.pkit.admin");}
			      else{
				      paylasim.alreadyClaimedkit(player);
				      if (!hasPack.contains(player.getName())) {
			    		  hasPack.add(player.getName());	
			    		  alanlar.set("Takes", hasPack);
			    		  try {alanlar.save(adakit);} catch (IOException e) {e.printStackTrace();
			    		  paylasim.debugSomethng("&cSomeone tried to take pKit with different account. Saving new account...");}}
				      else if (!hasPack2.contains(pi)) {
				    	  hasPack.add(player.getName());	
			    		  alanlarip.set("Takes", hasPack2);
			    		  try {alanlarip.save(adakitip);} catch (IOException e) {e.printStackTrace();
			    		  paylasim.debugSomethng("&cSomeone tried to take pKit with different ip. Saving new ip...");}}
				      
				      
			      }}
		      
		      else {
			      hasPack.add(player.getName());
			      hasPack2.add(pi);
			      alanlar.set("Takes", hasPack);
			      alanlarip.set("Takes", hasPack2);
			      try {alanlar.save(adakit);} catch (IOException e) {e.printStackTrace();}
			      try {alanlarip.save(adakitip);} catch (IOException e) {e.printStackTrace();}
			      paylasim.adakityeniAlan(player);
			  	  kitver(player);
			  	  paylasim.pkitdebug(player);
			  	paylasim.debugSomethng("&b" + player.getName() + " &a Has took the pkit.");}}}
		   else {
				paylasim.pkitdisabled(player);}
		}
		
		
		return false;
	}
	
	public void kitver(Player player) {
		for (String adakit2 : plugin.getConfig().getStringList("permantKit.kit-cmds")){
	  		adakit2 = adakit2.replaceAll("&", "§");
	  		adakit2 = adakit2.replaceAll("%player%", player.getName());
	  		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), adakit2);}
		
	}

}
