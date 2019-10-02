package me.geik.essas.metintasi;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.geik.essas.Main;
import me.geik.essas.acik.paylasim;

public class metinListener implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public metinListener(Main plugin){
		    this.plugin = plugin;}
	
	public static File metine = new File("plugins/Essas/locations/metinloc.yml");
  	public static FileConfiguration loc = YamlConfiguration.loadConfiguration(metine);
  	public static int can =  paylasim.cfg.getInt("metin.health");
  	public static int defaultcan =  paylasim.cfg.getInt("metin.health");
  	static int yetmisbescan = (int) defaultcan*75/100;
  	static int  ellican = (int) defaultcan*50/100;
  	static int  yirmibescan = (int) defaultcan*25/100;
  	
  	static HashMap<String, Integer> playersx = new HashMap<String, Integer>();
  	public static boolean metindurumu = true;

	@EventHandler
	public static void metin(BlockBreakEvent e) {
      if (loc.contains("Location.x") && loc.contains("Location.world")) {
	      if (loc.get("Location.x") != null && loc.get("Location.world") != null) {
			if(paylasim.cfg.getBoolean("metin.event") == true){
				
				Material material = e.getBlock().getType();
				String materialx = paylasim.cfg.getString("metin.metin-material");
				Player player = e.getPlayer();
				
			  if (metindurumu == true) {
				  	int x = loc.getInt("Location.x");
				  	int y = loc.getInt("Location.y");
				  	int z = loc.getInt("Location.z");
				  	String string = loc.getString("Location.world");
				  	World world = Bukkit.getServer().getWorld(string);
				if (material.equals(Material.getMaterial(materialx))){
					Location tas = new Location(world, x, y, z);
					
					if(e.getBlock().getLocation().equals(tas)){
						tasRestorasyonu(e, materialx);
						
						if (can >= 1){
							canEksilince(player);
							canEksilince2(player);
						}
						else if (can <= 0){
							tas.getBlock().setType(Material.AIR);
							metinhealthEvent("0", player);
							spawnmobs("0", player);
							
							Map<String, Integer> sorted = playersx
							        .entrySet()
							        .stream()
							        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							        .collect(
							            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
							                LinkedHashMap::new));
						 for (Map.Entry<String, Integer> playersx : sorted.entrySet()) {
							 String winner = playersx.getKey();
							 for (String metintasiKiran : paylasim.cfg.getStringList("metin.top-breaking-reward")){
								  metintasiKiran = metintasiKiran.replaceAll("&", "§");
								  metintasiKiran = metintasiKiran.replaceAll("%player%", winner);
								  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), metintasiKiran);}
							 break;
						 }
							playersx.clear();
							metindurumu = false;
							
							
							metincd2();
						}
					}
					
				}
				
			
		}
		}
      }
	}
	}
	public static void metinhealthEvent(String health, Player player) {
		  Set<String> keys = metinListener.playersx.keySet();
	      for(String key: keys){
			for (String metintasiKiran : paylasim.cfg.getStringList("metin.health-percent." + health + ".command")){
				  metintasiKiran = metintasiKiran.replaceAll("&", "§");
				  metintasiKiran = metintasiKiran.replaceAll("%player%", key);
				  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), metintasiKiran);}
			
		 }
		}
		
		public static void spawnmobs(String health, Player player) {
		  for (String mobs : paylasim.cfg.getStringList("metin.health-percent." + health + ".spawn-mob")){
			String[] count = mobs.split(",");
			int mobcount = Integer.valueOf(count[1]);
			EntityType mobtype = EntityType.valueOf(count[0]);
			for (int i = 0; i < mobcount ; i++) {
				player.getWorld().spawnEntity(player.getLocation().add(1, 2, 0), mobtype);}
		  }
				
	    }
		
		
		public static void canEksilince(Player player) {
			metinListener.can = metinListener.can-1;
			if (!metinListener.playersx.containsKey(player.getName())) {
				metinListener.playersx.put(player.getName(), 1);
			} else {
				int count = metinListener.playersx.get(player.getName());
				metinListener.playersx.remove(player.getName());
				metinListener.playersx.put(player.getName(), count + 1);
			}
			if (metinListener.yetmisbescan == metinListener.can) {
				metinhealthEvent("75", player);
				spawnmobs("75", player);
			}
			else if (metinListener.ellican == metinListener.can) {
				metinhealthEvent("50", player);
				spawnmobs("50", player);
			}
			else if (metinListener.yirmibescan == metinListener.can) {
				metinhealthEvent("25", player);
				spawnmobs("25", player);}
		}
		public static void canEksilince2(Player player) {
			if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health.enable") == true ) {
				if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health.zombie") == true) {
					int zombiecount = paylasim.cfg.getInt("metin.spawn-mob-every-health.zombie-count");
					for (int i = 0; i < zombiecount ; i++) {
						player.getWorld().spawnEntity(player.getLocation().add(1, 2, 0), EntityType.ZOMBIE);}
					
				}
				if (paylasim.cfg.getBoolean("metin.spawn-mob-every-health.skeleton") == true) {
					int skeletoncount = paylasim.cfg.getInt("metin.spawn-mob-every-health.skeleton-count");
					for (int i = 0; i < skeletoncount ; i++) {
						player.getWorld().spawnEntity(player.getLocation().add(1, 2, 0), EntityType.SKELETON);}
					
					
				}
			}
		}
		
		public static void tasRestorasyonu(BlockBreakEvent e, String matsx) {
			e.setCancelled(true);
			e.getBlock().setType(Material.getMaterial(matsx));
			e.getBlock().getDrops().clear();
		}
		
		public static BukkitRunnable metintask;
		public static void metincd2() {
			 if (metintask != null) {
				 metintask.cancel();
				 metintask = null;
		        }
			 metintask = new BukkitRunnable() {
		            @Override
		            public synchronized void cancel() throws IllegalStateException {
		                super.cancel();
		            }
		            public void run() {
		            	if (metinListener.loc.get("Location.x") != null && metinListener.loc.get("Location.world") != null) {
		            	int x = metinListener.loc.getInt("Location.x");
		    			int y = metinListener.loc.getInt("Location.y");
		    			int z = metinListener.loc.getInt("Location.z");
		    			String string = metinListener.loc.getString("Location.world");
		    			World world = Bukkit.getServer().getWorld(string);
		    			Location tas = new Location(world, x, y, z);
		    			String materialx = paylasim.cfg.getString("metin.metin-material");
		    			
		    			metinListener.can = metinListener.defaultcan;
		                	tas.getBlock().setType(Material.getMaterial(materialx));
		                	metinListener.metindurumu = true;
		                	 if (paylasim.cfg.getBoolean("metin.respawned-again-broadcast") == true) paylasim.metinStoneBroadcast();
		                	metintask.cancel();
		            	} else paylasim.metinTasNo(Bukkit.getServer().getConsoleSender());
		    			
		            	metintask.cancel();
		            }
		        }; metintask.runTaskLater(Main.instance, 20*60*paylasim.cfg.getInt("metin.respawn-cooldown"));
		    }
	
	

}
