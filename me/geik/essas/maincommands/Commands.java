package me.geik.essas.maincommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;

public class Commands implements CommandExecutor{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public Commands(Main plugin) {
		this.plugin = plugin;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("essas")) {
			// PLAYER
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					if (player.hasPermission("essas.admin")) {
						AdminGuiReturn.mainMenu(player);
					} else paylasim.noPerm(player);
				}
				else if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("allcmd")) {
						if (player.hasPermission("essas.admin")) {
							Voids.giveallExecute(player, args);
						} else paylasim.noPerm(player);
					}
					else if (args[0].equalsIgnoreCase("chatevent")) {
						if (player.hasPermission("essas.admin")) {
							if (paylasim.cfg.getBoolean("chat-event.events") == true) {
								Voids.chatEventAgain(player);
							} else paylasim.chatEventDisabled(player);
						} else paylasim.noPerm(player);
					}
					else if (args[0].equalsIgnoreCase("metinstone")) {
						if (player.hasPermission("essas.admin")) {
							if (paylasim.cfg.getBoolean("metin.event") == true) {
								Voids.metinagain(player);} else {
									paylasim.metinDisabled(player);
								}
						} else paylasim.noPerm(player);
					}
					else if (args[0].equalsIgnoreCase("reload")) {
						if (player.hasPermission("essas.admin")) {
							Voids.reloadConfig(player);
						}
					}
					else if (args[0].equalsIgnoreCase("license")) {
						player.sendMessage(paylasim.color("&2&lESSAS &2Info:"));
						player.sendMessage(paylasim.color("&2&l   ESSAS &2version: &a" + paylasim.version));
						player.sendMessage(paylasim.color("&2&l   ESSAS &2developed by &c&lGeyik"));
						player.sendMessage(paylasim.color("&2    License: &fCopyright 2019 ©Essas"));
						player.sendMessage(paylasim.color("&2    License based on &f&lMIT License"));
					}
					
					
					else {
						if (player.hasPermission("essas.admin")) {
							Voids.help(player);
						} else paylasim.noPerm(player);
					}
				} else paylasim.helpessas(player);
			}
			
			
			// CONSOLE
			else {
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("allcmd")) {
						Voids.giveallExecute(sender, args);
					}
					else if (args[0].equalsIgnoreCase("chatevent")) {
						if (paylasim.cfg.getBoolean("chat-event.events") == true) {
							Voids.chatEventAgain(sender);	
						} else paylasim.chatEventDisabled(sender);
					}
					else if (args[0].equalsIgnoreCase("metinstone")) {
						if (paylasim.cfg.getBoolean("metin.event") == true) {
							Voids.metinagain(sender);} else {
								paylasim.metinDisabled(sender);
							}
					}
					else if (args[0].equalsIgnoreCase("reload")) {
						Voids.reloadConfig(sender);
					}
					else Voids.help(sender);
				}
				else paylasim.helpessas(sender);
			}
		}
		return true;
	}

}
