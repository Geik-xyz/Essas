package me.geik.essas.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class chatListener implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public chatListener(Main plugin){
		    this.plugin = plugin;}
	
   @EventHandler
   public void OnChat(AsyncPlayerChatEvent event){
     Player player = event.getPlayer();
	    if(!(player.hasPermission("essas.sustur.bypass")) && Main.globalmute == true){
	      event.setCancelled(true);
	      paylasim.chatUnavailable(player);}}

}