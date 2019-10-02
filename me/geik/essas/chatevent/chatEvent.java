package me.geik.essas.chatevent;

import java.util.Date;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class chatEvent implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public chatEvent(Main plugin){
		    this.plugin = plugin;}
	
	
	public static final int dakika = 60*1000;
	public static int event_suresi = 1000*paylasim.cfg.getInt("chat-event.gameLong");
	public static int uzunluk = paylasim.cfg.getInt("chat-event.wordLong");
	public static String str = paylasim.cfg.getString("chat-event.chars");
	public static char[] karakterler = str.toCharArray();
	public static Date zmn_event;
	public static Date basladi;
	public static Random random = new Random();
	public static String hedef;
	
	
	  public static BukkitRunnable donguid;
	  public static void ChatEventBaslat() {
		  if (paylasim.cfg.getBoolean("chat-event.events") == true){
			    zmn_event = new Date(new Date().getTime()+10*1000);
			 if (donguid != null) {
				 donguid.cancel();
				 donguid = null;
		        }
			 donguid = new BukkitRunnable() {
		            @Override
		            public synchronized void cancel() throws IllegalStateException {
		                super.cancel();
		                Bukkit.getConsoleSender().sendMessage("cancelled");
		            }
		            public void run() {
		            	 if(new Date().getTime() >= zmn_event.getTime()){
							  if(Bukkit.getOnlinePlayers().size() >=  1){
					            eventBaslat();
					          }
							}
							else{
							  if(basladi != null){
								  if(new Date().getTime() >= (basladi.getTime()+event_suresi)){
								  basladi = null;
								  paylasim.noOneCompletedChatEvent();
								  }}}
		            }
		        };
		        donguid.runTaskTimer(Main.instance, 40L, 20L);
		  }
	}
	  
	  
	  public static void eventBaslat(){
		  zmn_event = new Date(new Date().getTime()+dakika*paylasim.cfg.getInt("chat-event.gameCoolDown"));
		  basladi = new Date();
	      hedef = rasgeleYaziOlustur();
	      paylasim.youhaveTime(String.valueOf(event_suresi/1000));
	    }
	  public static String rasgeleYaziOlustur(){
	      String yazi = "";
	      for(int i= 0;i<uzunluk;i++){
	    	int rasgele = random.nextInt(karakterler.length);
	    	yazi+= karakterler[rasgele];
	      }
	      return yazi;
	    }
	  public static void odul(Player player) {
		  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
			  @Override
		      public void run() {
				  for (String ap0 : paylasim.cfg.getStringList("chat-event.reward")){
					  ap0 = ap0.replaceAll("&", "§");
					  ap0 = ap0.replaceAll("%player%", player.getName());
					  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ap0);
					  }
			  }
				 
		  },10L);
	  }
	  
}
