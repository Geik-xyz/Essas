package me.geik.essas.chatevent;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;

public class chatEventListener implements Listener{
	
	private Main plugin;
	public chatEventListener(Main plugin){
		    this.plugin = plugin;}
	
	 @EventHandler
	  public void dinleyici(AsyncPlayerChatEvent e){
	    if(chatEvent.basladi != null){
	  	if(e.getMessage().equals(chatEvent.hedef)){
	  		Player player = e.getPlayer();
	  		double zmn = (double) (chatEvent.event_suresi-(new Date().getTime()-chatEvent.basladi.getTime()));
	  		zmn = zmn/1000;
	  		double xmnxz = chatEvent.event_suresi/1000-zmn;
	  		String zmns = new DecimalFormat("#.##").format(xmnxz);
	  		paylasim.playerHasCompletedChatEvent(zmns, player);
	              e.setCancelled(true);
	              chatEvent.basladi = null;
	        chatEvent.odul(player);
	  	}
	    
	    }}
	 @SuppressWarnings("deprecation")
	@EventHandler
	 public void updateListen(PlayerJoinEvent e) {
		 if ((plugin.getConfig().getBoolean("updateChecker") == true)){
			 Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable(){
				  public void run(){
					  if (e.getPlayer().isOp()){
						  if (Main.update == true){
							  paylasim.updateAvailable(e.getPlayer());
						  }
						  else {
							  paylasim.latestVersion(e.getPlayer());}}}}, 100);
			 
		 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 // Gui interacts
	 @EventHandler
	 public void invchatClick(InventoryClickEvent e) {
		  Player p = (Player) e.getWhoClicked();
		  chatEventGuiMenu.chatGuiMain(e, p);
		  chatEventCmmds.cmmdsMenu(e, p, "&dChat Even GUI-Cmds", "chat-event.reward");
	  }
	 
	 @EventHandler
	 public void chatEventGuiEdit(AsyncPlayerChatEvent e) throws IOException {
	   Player p = (Player) e.getPlayer();
	   if (chatEventGuiMenu.playerEdit.containsKey(p.getName())) {
		 e.setCancelled(true);
		 if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
			 chatEventGuiMenu.playerEdit.remove(p.getName());
			 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				 public void run() {
					 AdminGuiReturn.ChatEventMainRE(p); 
				 }
			 }, 1);
		 } else {
			 if (chatEventGuiMenu.playerEdit.get(p.getName())== "chars") {
				 paylasim.cfg.set("chat-event." + chatEventGuiMenu.playerEdit.get(p.getName()), e.getMessage());} 
			 else  paylasim.cfg.set("chat-event." + chatEventGuiMenu.playerEdit.get(p.getName()), Integer.valueOf(e.getMessage()));
			 paylasim.cfg.save(paylasim.c);
			 chatEventGuiMenu.playerEdit.remove(p.getName());
			 chatEvent.donguid.cancel();
			 
			 
			 chatEvent.basladi = null;
			 chatEvent.zmn_event = new Date(new Date().getTime()+chatEvent.dakika*paylasim.cfg.getInt("chat-event.gameCoolDown"));
			 chatEvent.event_suresi = 1000*paylasim.cfg.getInt("chat-event.gameLong");
			 chatEvent.uzunluk = paylasim.cfg.getInt("chat-event.wordLong");
			 chatEvent.str = paylasim.cfg.getString("chat-event.chars");
			 chatEvent.karakterler = chatEvent.str.toCharArray();
			 
			 chatEvent.ChatEventBaslat();
			 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
				 public void run() {
					 AdminGuiReturn.ChatEventMainRE(p); 
				 }
			 }, 1);
		 }
	   }
	   // Add cmd
	   else if (chatEventCmmds.playercmds.containsKey(p.getName())) {
		   e.setCancelled(true);
		   if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
			   chatEventCmmds.playercmds.remove(p.getName());
				 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					 public void run() {
						 chatEventCmmds.cmdListMenu(p); 
					 }
				 }, 1);
			 } else {
				 chatEventCmmds.playercmds.remove(p.getName());
				 List<String> list = paylasim.cfg.getStringList("chat-event.reward");
				 list.add(e.getMessage());
				 paylasim.cfg.set("chat-event.reward", list);
				 paylasim.cfg.save(paylasim.c);
				 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
					 public void run() {
				 chatEventCmmds.cmdListMenu(p);
					 }
				 }, 1);
			 }
	   }
	   
	   
	   
	   
	   
	 }

}
