package me.geik.essas.metintasi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;
import me.geik.essas.permantKit.adakitGuiCMDS;

public class metinGuiListener implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public metinGuiListener(Main plugin) {
		this.plugin = plugin;
	}
	
	public static HashMap<String, String> playerEdit = new HashMap<String, String>();
	
	
	@EventHandler
	public void onGuiInteractsMetin(InventoryClickEvent e) throws IOException {
		Player player = (Player) e.getWhoClicked();
		metinSpawnMobEveryGuiListener.metinGuiMain(e, player);
		adakitGuiCMDS.cmmdsMenu(e, player, "&dMetin-TopBreaking Reward", "metin.top-breaking-reward", "metinstone", 99);
		metinSpawnMobEveryGuiListener.spawnMobEveryGui(e);
		metinHealthPercentageGUI.metinHealthPercentage(e);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-CMDS-", "metin.health-percent." + 0 + ".command", "mcmds", 0);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-CMDS-", "metin.health-percent." + 25+ ".command", "mcmds", 25);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-CMDS-", "metin.health-percent." + 50+ ".command", "mcmds", 50);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-CMDS-", "metin.health-percent." + 75+ ".command", "mcmds", 75);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-MOBS-", "metin.health-percent." + 0 + ".spawn-mob", "mmobs", 0);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-MOBS-", "metin.health-percent." + 25+ ".spawn-mob", "mmobs", 25);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-MOBS-", "metin.health-percent." + 50+ ".spawn-mob", "mmobs", 50);
		adakitGuiCMDS.cmmdsMenu(e, player, "&4Metin-MOBS-", "metin.health-percent." + 75+ ".spawn-mob", "mmobs", 75);
	}
	
	 @EventHandler
	 public void metinChatData(AsyncPlayerChatEvent e) throws IOException {
	   Player p = (Player) e.getPlayer();
	   if (playerEdit.containsKey(p.getName())) {
		 e.setCancelled(true);
		 if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
			 playerEdit.remove(p.getName());
			 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				 public void run() {
					 AdminGuiReturn.metinMainRE(p); 
				 }
			 }, 1);
		 } else {
			 if (playerEdit.get(p.getName()) == "health") {
				 paylasim.cfg.set("metin." + playerEdit.get(p.getName()), Integer.valueOf(e.getMessage()));}
			 else if (playerEdit.get(p.getName()) == "respawn-cooldown") {
				 paylasim.cfg.set("metin." + playerEdit.get(p.getName()), Integer.valueOf(e.getMessage()));
			 }
			 else if (playerEdit.get(p.getName()) == "metin-material") {
				 paylasim.cfg.set("metin." + playerEdit.get(p.getName()), e.getMessage());
			 }
			 else if (playerEdit.get(p.getName()) == "zombie-count") {
				 paylasim.cfg.set("metin.spawn-mob-every-health." + playerEdit.get(p.getName()), Integer.valueOf(e.getMessage()));
			 }
			 else if (playerEdit.get(p.getName()) == "skeleton-count") {
				 paylasim.cfg.set("metin.spawn-mob-every-health." + playerEdit.get(p.getName()), Integer.valueOf(e.getMessage()));
			 }
			 
			 paylasim.cfg.save(paylasim.c);
			 playerEdit.remove(p.getName());
			 metinListener.metintask.cancel();
			 metinListener.metincd2();

			 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				 public void run() {
					 AdminGuiReturn.metinMainRE(p); 
				 }
			 }, 1);
		 }
	   }
	   // Add cmd
	   else if (adakitGuiCMDS.pkitCMD.containsKey(p.getName())) {
		   if (adakitGuiCMDS.pkitCMD.get(p.getName()) == 0)  {
		   e.setCancelled(true);
		   if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
			   adakitGuiCMDS.pkitCMD.remove(p.getName());
				 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					 public void run() {
						 adakitGuiCMDS.cmdListMenu(p, "metin.top-breaking-reward", "&dMetin-TopBreaking Reward");
					 }
				 }, 1);
			 } else {
				 adakitGuiCMDS.pkitCMD.remove(p.getName());
				 List<String> list = paylasim.cfg.getStringList("metin.top-breaking-reward");
				 list.add(e.getMessage());
				 paylasim.cfg.set("metin.top-breaking-reward", list);
				 paylasim.cfg.save(paylasim.c);
				 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					 public void run() {
						 adakitGuiCMDS.cmdListMenu(p, "metin.top-breaking-reward", "&dMetin-TopBreaking Reward");
					 }
				 }, 1);
			 }
		   }
		   else if (adakitGuiCMDS.pkitCMD.get(p.getName()) == 3) {
			   e.setCancelled(true);
			   if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
				   adakitGuiCMDS.pkitCMD.remove(p.getName());
					 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
						 public void run() {
							 adakitGuiCMDS.cmdListMenu(p, "metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".command", "&4Metin-CMDS-" + adakitGuiCMDS.mmenuName.get(p.getName()));
							 adakitGuiCMDS.mmenuName.remove(p.getName());
						 }
					 }, 1);
				 } else {
					 adakitGuiCMDS.pkitCMD.remove(p.getName());
					 List<String> list = paylasim.cfg.getStringList("metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".command");
					 list.add(e.getMessage());
					 paylasim.cfg.set("metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".command", list);
					 paylasim.cfg.save(paylasim.c);
					 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
						 public void run() {
							 adakitGuiCMDS.cmdListMenu(p, "metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".command", "&4Metin-CMDS-" + adakitGuiCMDS.mmenuName.get(p.getName()));
							 adakitGuiCMDS.mmenuName.remove(p.getName());
						 }
					 }, 1);
				 }
		   }
		   else if (adakitGuiCMDS.pkitCMD.get(p.getName()) == 2) {
			   e.setCancelled(true);
			   if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
				   adakitGuiCMDS.pkitCMD.remove(p.getName());
					 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
						 public void run() {
							 adakitGuiCMDS.cmdListMenu(p, "metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".spawn-mob", "&4Metin-MOBS-" + adakitGuiCMDS.mmenuName.get(p.getName()));
							 adakitGuiCMDS.mmenuName.remove(p.getName());
						 }
					 }, 1);
				 } else {
					 adakitGuiCMDS.pkitCMD.remove(p.getName());
					 List<String> list = paylasim.cfg.getStringList("metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".spawn-mob");
					 list.add(e.getMessage());
					 paylasim.cfg.set("metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".spawn-mob", list);
					 paylasim.cfg.save(paylasim.c);
					 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
						 public void run() {
							 adakitGuiCMDS.cmdListMenu(p, "metin.health-percent." + adakitGuiCMDS.mmenuName.get(p.getName()) + ".spawn-mob", "&4Metin-MOBS-" + adakitGuiCMDS.mmenuName.get(p.getName()));
							 adakitGuiCMDS.mmenuName.remove(p.getName());
						 }
					 }, 1);
				 }
		   }
	   }
	   
	   
	   
	   
	   
	 }

}
