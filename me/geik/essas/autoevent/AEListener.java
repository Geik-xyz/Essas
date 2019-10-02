package me.geik.essas.autoevent;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;
import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;
import me.geik.essas.gui.AdminGuiReturn;

public class AEListener implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	  
	  public AEListener(Main plugin){
		    this.plugin = plugin;}
	  
	  private static SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
	  public static String destination;
	  
	  
	  
	  //GUI LISTENER
	  
	  @EventHandler
	  public void inventoryAEClick(InventoryClickEvent e) {
		  Player p = (Player) e.getWhoClicked();
		  AEGuiMain.AEMain(e, p);
	  }
	  
	  @EventHandler
	  public void AEChatEvent(AsyncPlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String setting = "command";
		  if (AEGuiMain.playerEditAE.containsKey(p.getName())) {
			  e.setCancelled(true);
			  int deger =AEGuiMain.playerEditAE.get(p.getName());
			  if (deger == 1) {
				  setting = "command";}
			  else {
				  setting = "time";}
		  
			  if (e.getMessage().equalsIgnoreCase(paylasim.cfg.getString("cancelMethod"))){
				  AEGuiMain.playerEditAE.remove(p.getName());
				  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run() {AdminGuiReturn.AEEventsRE(p, 
						  AEGuiMain.playerEditMenu.get(p.getName()));
				  AEGuiMain.playerEditMenu.remove(p.getName());
				  }}, 1);
			  }
			  else {
				  paylasim.cfg.set("autoEvent." + AEGuiMain.playerEditMenu.get(p.getName()) + "." + setting, e.getMessage());
				  try {paylasim.cfg.save(paylasim.c);} catch (IOException e1) {e1.printStackTrace();}
				  Main.instance.reloadConfig();
				  AEGuiMain.playerEditAE.remove(p.getName());
				  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {public void run() {AdminGuiReturn.AEEventsRE(p, 
						  AEGuiMain.playerEditMenu.get(p.getName()));
				  AEGuiMain.playerEditMenu.remove(p.getName());
				  }}, 1);
			  }
		}
     }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public static boolean hastimeconfig() {
		  
		  for(String s : paylasim.cfg.getConfigurationSection("autoEvent").getKeys(false)){
			  if(AEListener.format.format(new Date()).equals(paylasim.cfg.getString("autoEvent." + s + ".time"))){
				  destination = s;
				  if (s.equalsIgnoreCase("third") || s.equalsIgnoreCase("second") || s.equalsIgnoreCase("first")) {
					  return true;
				  }
				  
			  }
		  }
		return false;
	  
	  }
	  
	
	public static BukkitRunnable taskid;
	public static void taskAgain() {
		 if (taskid != null) {
			 taskid.cancel();
	         taskid = null;
	        }
		 taskid = new BukkitRunnable() {
	            @Override
	            public synchronized void cancel() throws IllegalStateException {
	                super.cancel();
	            }
	            public void run() {
	                if (AEListener.hastimeconfig()) {
	                	yunin();
	                	taskid.cancel();
	                }
	            }
	        };
	        taskid.runTaskTimer(Main.instance, 1L, 1L);
	    }
	public static void yunin() {
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), 
		Main.instance.getConfig().getString("autoEvent." + destination + ".command").replace("&", "§"));
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			public void run() {
				taskAgain();
			}
		}, 25L);
	}
	
	  

}
