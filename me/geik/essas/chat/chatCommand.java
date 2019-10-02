package me.geik.essas.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class chatCommand implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public chatCommand(Main plugin) {
		this.plugin = plugin;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("clear")) {
			if (sender instanceof Player) {
			  Player player = (Player) sender;
				if (args.length == 1) {
				  if (args[0].equalsIgnoreCase("all")) {
					if (player.hasPermission("essas.clear.admin")) {
					  clearAll(player);} else paylasim.noPerm(player);}
				  else if (args[0].equalsIgnoreCase("self")) {
					for(int i=0; i < 30; i ++){
		          	  player.sendMessage("");}
					paylasim.clearedSelf(player);}
				  else {
					if (player.hasPermission("essas.chat.admin")) {
					  clearSelfTargetted(sender, args);} 
					else paylasim.noPerm(player);
					}
				} else paylasim.clearWrong(player);
			} else {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("all")) {clearAll(sender);}
					else {clearSelfTargetted(sender, args);}
				} else paylasim.clearWrong(sender);
			}
		}
		/*
		  	mute
		 */
		if (label.equalsIgnoreCase("mutechat")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("essas.chat.mute")) {
					if (Main.globalmute == false) {
						  Main.globalmute = true;
						  paylasim.chatMuted(player);
					  } else {
						  Main.globalmute = false;
						  paylasim.chatunMuted(player);
					  }
				} else paylasim.noPerm(player);
				
			}
			else {
			  if (Main.globalmute == false) {
				  Main.globalmute = true;
				  paylasim.chatMutedCONSOLE();
			  } else {
				  Main.globalmute = false;
				  paylasim.chatunMutedCONSOLE();
			  }
			}
		}
		return false;
	}
	
	/*
	
	
	
				Chat Clear voids
	
	
	
	
	
	
	
	
	*/
	
	public void clearSelfTargetted(CommandSender sender, String[] args) {
		Player target = Bukkit.getPlayerExact(args[0]);
		if (target == null) {paylasim.playerOffline(sender);}
		else {
			for(int i=0; i < 30; i ++){
	      	    target.sendMessage("");}
			paylasim.chatClearedBy(target, sender);
		}
	}
	public void clearAll(CommandSender sender) {
			for(Player p : Bukkit.getOnlinePlayers()){
	          	  for(int i=0; i < 30; i ++){
	          	    p.sendMessage("");}
	         if (sender instanceof Player) {
	          	paylasim.chatClearedBy(p, sender);
	          	paylasim.chatClearedByDEBUG(Bukkit.getConsoleSender(), sender);}
	         else {paylasim.chatClearedByCONSOLE(p);}}}
		
	
	

}
