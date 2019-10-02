package me.geik.essas.permantKit;

import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class adakitGui implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public adakitGui(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void guiClick(InventoryClickEvent e) throws IOException {
		Player p = (Player) e.getWhoClicked();
		adakitGuiCMDS.cmmdsMenu2(e, p);
		adakitGuiCMDS.cmmdsMenu(e, p, "&bpKit-CMDS", "permantKit.kit-cmds", "adakit", 0);
	}
	
	//Chat listener - pKÝT
	
	 @EventHandler
	 public void pkitChatevent(AsyncPlayerChatEvent e) throws IOException {
	   Player p = (Player) e.getPlayer();
	   if (adakitGuiCMDS.pkitCMD.containsKey(p.getName())) {
		 if (adakitGuiCMDS.pkitCMD.get(p.getName()) == 1) {
		 e.setCancelled(true);
		 if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
			 adakitGuiCMDS.pkitCMD.remove(p.getName());
			 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				 public void run() {
					 adakitGuiCMDS.cmdListMenu(p, "permantKit.kit-cmds", "&bpKit-CMDS");
				 }
			 }, 1);
		 } else {
			 adakitGuiCMDS.pkitCMD.remove(p.getName());
			 List<String> est = paylasim.cfg.getStringList("permantKit.kit-cmds");
			 est.add(e.getMessage());
			 paylasim.cfg.set("permantKit.kit-cmds", est);
			 paylasim.cfg.save(paylasim.c);
			 Main.instance.reloadConfig();

			 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				 public void run() {
					 adakitGuiCMDS.cmdListMenu(p, "permantKit.kit-cmds", "&bpKit-CMDS");
				 }
			 }, 1);
		 
		 }
	   }
	   
	   
	   }
	   
	 }

}
