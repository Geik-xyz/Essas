package me.geik.essas.autoevent;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class AECommands implements CommandExecutor {
	
	
	@SuppressWarnings("unused")
	private Main plugin;
	public AECommands(Main plugin) {
	    this.plugin = plugin;}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("autoevent")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (player.hasPermission("essas.autoevent.admin")) {
					commandOtoEvent(player, args);
					
					
				} paylasim.noPerm(player);
			} else commandOtoEvent(sender, args);
		}
		
		return false;
	}
	
	public static void commandOtoEvent(CommandSender sender, String[] argx){
		if (argx.length == 1) {
			if (argx[0].equalsIgnoreCase("first") || argx[0].equalsIgnoreCase("1")) {
				argsofEvent("first");
				paylasim.AEcommandExecuted(sender, "first");
			}
			else if (argx[0].equalsIgnoreCase("second") || argx[0].equalsIgnoreCase("2")) {
				argsofEvent("second");
				paylasim.AEcommandExecuted(sender, "second");
			}
			else if (argx[0].equalsIgnoreCase("third") || argx[0].equalsIgnoreCase("3")) {
				argsofEvent("third");
				paylasim.AEcommandExecuted(sender, "third");
			} else paylasim.wrongcommandAE(sender);
		}
		else {
			paylasim.wrongcommandAE(sender);
		}
	}
	
	public static void argsofEvent(String numberS) {
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),
					paylasim.cfg.getString("autoEvent." + numberS + ".command").replace("&", "§"));
	}

}
